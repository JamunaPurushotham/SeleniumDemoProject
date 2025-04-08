package CampaignTest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class CreateCampaignTest extends BaseClass {

	//@Parameters("browser")
	@Test()

	public void createCampaignWithAllFieldTest() throws InterruptedException, IOException {

		// generating random number using java utility
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNumber(2000);

		String closeDate = JavaUtility.generateReqDate(1);
		System.out.println(closeDate);

		// Reading excel file for campaign data using excel file utility
		ExcelFileUtility excelFile = new ExcelFileUtility();
		String campaignName = excelFile.readingDataFromExcel("CampaignData", 1, 2) + randomNum;
		String TargetData = excelFile.readingDataFromExcel("CampaignData", 1, 3);
		String TargetAudience = excelFile.readingDataFromExcel("CampaignData", 1, 4);
		String CampaignStatus = excelFile.readingDataFromExcel("CampaignData", 1, 5);
		String Description = excelFile.readingDataFromExcel("CampaignData", 1, 6);

		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		CreateCampaignPage ccp = new CreateCampaignPage(driver);

		ccp.createCampaignWithAllFields(campaignName, TargetData, closeDate, TargetAudience, CampaignStatus,
				Description);

		Thread.sleep(2000);

		String ConfMsg = cp.getConfMsg().getText();
		if (ConfMsg.contains(campaignName)) {

			Reporter.log("Campaign" + campaignName + " added Successfully");
		} else {
			Reporter.log("campaign not added");
		}
		Thread.sleep(4000);

	}

//	@Parameters("browser")
	// @Test (groups= {"FunctionalTesting"})
	@Test
	public void createCampaignWithCloseDateTest() throws InterruptedException, IOException {

		// generating random number using java utility
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNumber(2000);

		String closeDate = JavaUtility.generateReqDate(1);
		System.out.println(closeDate);

		// Reading excel file for campaign data using excel file utility
		ExcelFileUtility excelFile = new ExcelFileUtility();
		String campaignName = excelFile.readingDataFromExcel("CampaignData", 1, 2) + randomNum;
		String TargetData = excelFile.readingDataFromExcel("CampaignData", 1, 3);

//        // Cross browser testing
//        WebDriver driver = null;
//        if (BROWSER.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else if (BROWSER.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//
//        } else if (BROWSER.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//        } else {
//            driver = new ChromeDriver();
//        }

		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		CreateCampaignPage ccp = new CreateCampaignPage(driver);

		ccp.createCampaignWithCloseDate(campaignName, TargetData, closeDate);

		Thread.sleep(2000);

		String ConfMsg = cp.getConfMsg().getText();
		if (ConfMsg.contains(campaignName)) {

			Reporter.log("Campaign" + campaignName + " added Successfully");
		} else {
			Reporter.log("campaign not added");
		}
		Thread.sleep(4000);

	}

	//@Parameters("browser")
	// @Test (groups= {"FunctionalTesting"})
	@Test
	public void createCampaignWIthMandatoryFieldsTest() throws InterruptedException, IOException {
		// generating random number using java utility
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNumber(2000);

		String closeDate = JavaUtility.generateReqDate(1);
		System.out.println(closeDate);

		// Reading excel file for campaign data using excel file utility
		ExcelFileUtility excelFile = new ExcelFileUtility();
		String campaignName = excelFile.readingDataFromExcel("CampaignData", 1, 2) + randomNum;
		String TargetData = excelFile.readingDataFromExcel("CampaignData", 1, 3);

		// Maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();

		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		CreateCampaignPage ccp = new CreateCampaignPage(driver);

		ccp.createCampaignWithmandatoryFields(campaignName, TargetData);

		Thread.sleep(2000);

		String ConfMsg = cp.getConfMsg().getText();
		if (ConfMsg.contains(campaignName)) {

			Reporter.log("Campaign" + campaignName + " added Successfully", true);
		} else {
			Reporter.log("campaign not added", true);
		}
		Thread.sleep(4000);
		

	}
}