package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductPage {

	WebDriver driver;

	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "quantity")
	private WebElement quantity;

	@FindBy(name = "productName")
	private WebElement prdctNme;

	@FindBy(name = "price")
	private WebElement pricepricePerUnit;

	@FindBy(name = "productCategory")
	private WebElement productcategory;

	@FindBy(name = "vendorId")
	private WebElement vendorName;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addProductBtn;

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrdctNme() {
		return prdctNme;
	}

	public WebElement getPricepricePerUnit() {
		return pricepricePerUnit;
	}

	public WebElement getProductcategory() {
		return productcategory;
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public void createProduct(String qnty, String productName, String price) {
		quantity.sendKeys(qnty);
		prdctNme.sendKeys(productName);
		pricepricePerUnit.sendKeys(price);
		WebDriverUtility webUtil = new WebDriverUtility();
		webUtil.select(productcategory, "Electronics");
		webUtil.select(vendorName, "VID_008");
		addProductBtn.click();
		

	}

}
