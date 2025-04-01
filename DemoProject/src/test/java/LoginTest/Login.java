package LoginTest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class Login extends BaseClass{

	//@Parameters("browser")
	//@Test(groups = { "RegressionTesting" })
	@Test(retryAnalyzer = genericListenerUtility.RetryListenerImp.class)
	public void loginTest() throws InterruptedException, IOException {

		PropertiesFileUtility prop = new PropertiesFileUtility();
		String BROWSER = prop.readingDataFromUtilityFile("browser");
		//String BROWSER = browser;
		String URL = prop.readingDataFromUtilityFile("url");
		String UserName = prop.readingDataFromUtilityFile("uname");
		String Password = prop.readingDataFromUtilityFile("pwd");

		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(UserName);
		System.out.println(Password);

		String expectedURL = "http://49.249.28.218:8098/dashbod";

		// Cross browser testing
		WebDriver driver = null;
//		ChromeOptions cOption = new ChromeOptions();
//		FirefoxOptions fOption = new FirefoxOptions();
//		EdgeOptions eOption = new EdgeOptions();
//		cOption.addArguments("--headless");
//		fOption.addArguments("--headless");
//		eOption.addArguments("--headless");
//
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver(cOption);
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver(fOption);
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver(eOption);
//		} else {
//			driver = new ChromeDriver(cOption);
//		}
		
		 
	        if (BROWSER.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (BROWSER.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();

	        } else if (BROWSER.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        } else {
	            driver = new ChromeDriver();
	        }

		// Maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Navigate to the URL
		driver.get(URL);

		// login into the application
		LoginPage lp = new LoginPage(driver);
		lp.login(UserName, Password);
		Thread.sleep(2000);

		// verification of dashboard
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL, "Validation is failed");
		Reporter.log("Validation is passed", true);

		// logout
		DashboardPage dp = new DashboardPage(driver);
		dp.logout();
		Thread.sleep(2000);
		driver.quit();

	}
}
