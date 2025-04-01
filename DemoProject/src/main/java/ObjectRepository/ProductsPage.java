package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class = 'btn btn-info']")
	private WebElement createProductBtn;

	@FindBy(xpath="//div[@role='alert']")
	private WebElement confMsg;

	
	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}

	public WebElement getConfMsg() {
		return confMsg;
	}

}
