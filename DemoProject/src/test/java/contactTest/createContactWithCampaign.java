package contactTest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;

//@Listeners(ListenerImp.class)
public class createContactWithCampaign extends BaseClass {

	//@Parameters("browser")
	@Test(groups = { "IntegrationTesting" })
	public void createContactWithCampaignTest() throws IOException, InterruptedException {

		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNumber(2000);

		ExcelFileUtility excelFile = new ExcelFileUtility();
		String campaignName = excelFile.readingDataFromExcel("CampaignData", 1, 2) + randomNum;
		String TargetData = excelFile.readingDataFromExcel("CampaignData", 1, 3);

		String organization = excelFile.readingDataFromExcel("ContactData", 1, 2) + randomNum;
		String title = excelFile.readingDataFromExcel("ContactData", 1, 3);
		String contactName = excelFile.readingDataFromExcel("ContactData", 1, 4) + randomNum;
		String mobile = excelFile.readingDataFromExcel("ContactData", 1, 5);

		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);

		// Creating Campaign
		dp.getCampaignsLink().click();
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaignWithmandatoryFields(campaignName, TargetData);
		Thread.sleep(5000);

		// Creating Contact
		WebElement contactLink = dp.getContactsLink();
		WebDriverUtility webUtil = new WebDriverUtility();
		webUtil.waitForElementToBeClickable(driver, contactLink, 20);
		contactLink.click();
		Thread.sleep(2000);

		ContactsPage contPage = new ContactsPage(driver);
		WebElement createContactBtn = contPage.getCreateContactBtn();
		createContactBtn.click();

		CreateContactPage crtCntctPage = new CreateContactPage(driver);
		crtCntctPage.createContactWithCampaign(organization, title, contactName, mobile, "selectCampaign",
				"create-contact", campaignName);

		Thread.sleep(3000);

		// verifying the confirmation message
		String ConfirmationMsg = contPage.getConfMsg().getText();
		if (ConfirmationMsg.contains(contactName)) {

			Reporter.log("Contact" + contactName + " added Successfully");
		} else {
			Reporter.log("Contact not added");
		}
		Thread.sleep(5000);

	}

}