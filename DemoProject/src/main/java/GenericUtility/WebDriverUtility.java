package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForElementPresent(WebDriver driver, WebElement element, long sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element, long sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//	public void switchToWindow(WebDriver driver, String partialUrl) {
//		Set<String> allWindowIds = driver.getWindowHandles();
//		for (String Window : allWindowIds) {
//			driver.switchTo().window(Window);
//			String actUrl = driver.getCurrentUrl();
//			if (actUrl.contains(partialUrl)) {
//				break;
//			}
//		}
//	}
	
	public void switchToWindow(WebDriver driver, String partialUrl) {
	    Set<String> allWindowIds = driver.getWindowHandles();
	    
	    for (String windowId : allWindowIds) {
	        driver.switchTo().window(windowId);
	        String actualUrl = driver.getCurrentUrl();
	        
	        if (actualUrl.contains(partialUrl)) {
	            return;  // Exit the method once the correct window is found
	        }
	    }
	    
	    throw new NoSuchWindowException("No window found containing URL: " + partialUrl);
	}


	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void select(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select(String visibleText, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void performDoubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public void performContextClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void takingScreenShotOfWebPage(WebDriver driver, String fileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp= ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+fileName+".png");
		FileHandler.copy(temp, dest);		
	}
	
	public void takingScreenShotOfWebElement(WebElement element, String fileName) throws IOException
	{
		
		File temp= element.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+fileName+".png");
		FileHandler.copy(temp, dest);		
	}
	
	

}
