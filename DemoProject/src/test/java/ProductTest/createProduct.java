package ProductTest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductsPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;


//@Listeners(ListenerImp.class)
public class createProduct extends BaseClass{

//	@Parameters("browser")
	@Test (groups= {"SmokeTesting"})
	public void createProductTest() throws IOException, InterruptedException {

		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNumber(2000);
		ExcelFileUtility excelFile = new ExcelFileUtility();
		String Quantity = excelFile.readingDataFromExcel("ProductData", 1, 2);
		String ProductName = excelFile.readingDataFromExcel("ProductData", 1, 3) + randomNum;
		String pricePerUnit = excelFile.readingDataFromExcel("ProductData", 1, 4);

		
		DashboardPage dp = new DashboardPage(driver);
		WebElement productLink = dp.getProductsLink();
		WebDriverUtility webUtil = new WebDriverUtility();
		webUtil.waitForElementToBeClickable(driver, productLink, 20);
		productLink.click();
		Thread.sleep(2000);

		ProductsPage pp = new ProductsPage(driver);
		WebElement createProductbtn = pp.getCreateProductBtn();
		webUtil.waitForElementToBeClickable(driver, createProductbtn, 20);
		createProductbtn.click();
		Thread.sleep(2000);

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(Quantity, ProductName, pricePerUnit);

		Thread.sleep(5000);

		String confMsg = driver.findElement(By.xpath("//div[text()='Product "+ProductName+" Successfully Added']")).getText();
		Thread.sleep(2000);
		if (confMsg.contains(ProductName)) {
			System.out.println("Product added Successfully");
		} else {
			System.out.println("Product not added");
		}
		Thread.sleep(5000);

		System.out.println("Passed");

	}

}
