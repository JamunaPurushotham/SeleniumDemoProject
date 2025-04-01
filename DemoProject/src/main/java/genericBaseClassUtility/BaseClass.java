package genericBaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import GenericUtility.DatabaseUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver=null;
	DatabaseUtility dbUtil = new DatabaseUtility();
	PropertiesFileUtility propUtil = new PropertiesFileUtility();
	
	

	@BeforeSuite
	public void beforeSuite() throws SQLException {
		System.out.println("Before Suite - Established Database Connection");
		dbUtil.getDBConnection("jdbc:mysql://localhost:3306/Ninza", "root", "admin");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test - Pre Configuration Setup");

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before Class - Launch the Browser");
		String BROWSER = propUtil.readingDataFromUtilityFile("browser");
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
		sdriver=driver;
		// Maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("Before Method - Login");
		String URL = propUtil.readingDataFromUtilityFile("url");
		String UserName = propUtil.readingDataFromUtilityFile("uname");
		String Password = propUtil.readingDataFromUtilityFile("pwd");
		// Navigate to the URL
		driver.get(URL);
		// enter the username and password
		LoginPage lp = new LoginPage(driver);

		lp.login(UserName, Password);

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method - Logout");
		DashboardPage dp = new DashboardPage(driver);

		dp.logout();

	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class - Quit the Browser");
		// close the browser
		driver.quit();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test - Post Configuration setup");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite - Close Database Connection");
		dbUtil.closeDBconnection();

	}

}
