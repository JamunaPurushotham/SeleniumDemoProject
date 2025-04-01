package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
    WebDriver driver;

    public CreateCampaignPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="campaignName")
    private WebElement campaignName;

    @FindBy(name="targetSize")
    private WebElement targetSize;

    @FindBy(name="targetAudience")
    private WebElement targetAudience;

    @FindBy(name="campaignStatus")
    private WebElement CampaignStatus;

    @FindBy(name="expectedCloseDate")
    private WebElement expectedCloseDate;

    @FindBy(xpath="//textarea[@name='description']")
    private WebElement dscrptn;

    @FindBy(xpath="//button[text()='Create Campaign']")
    private WebElement createCampaignBtn;

    public WebElement getCampaignName() {
        return campaignName;
    }

    public WebElement getTargetSize() {
        return targetSize;
    }

    public WebElement getTargetAudience() {
        return targetAudience;
    }

    public WebElement getCampaignStatus() {
        return CampaignStatus;
    }

    public WebElement getExpectedCloseDate() {
        return expectedCloseDate;
    }

    public WebElement getDscrptn() {
        return dscrptn;
    }

    public WebElement getCreateCampaignBtn() {
        return createCampaignBtn;
    }

    public void createCampaignWithmandatoryFields(String campName, String target)
    {
        campaignName.sendKeys(campName);
        targetSize.clear();
        targetSize.sendKeys(target);
        createCampaignBtn.click();
    }
    public void createCampaignWithCloseDate(String campName,String target,String date)
    {
        campaignName.sendKeys(campName);
        targetSize.clear();
        targetSize.sendKeys(target);
        expectedCloseDate.sendKeys(date);
        createCampaignBtn.click();
    }

    public void createCampaignWithAllFields(String campName,String target,String date, String targetAud, String campStatus, String Description) throws InterruptedException {
        campaignName.sendKeys(campName);
        targetSize.clear();
        targetSize.sendKeys(target);
        Thread.sleep(500);
        expectedCloseDate.sendKeys(date);
        Thread.sleep(500);
        targetAudience.sendKeys(targetAud);
        Thread.sleep(500);
        CampaignStatus.sendKeys(campStatus);
        Thread.sleep(500);
        dscrptn.sendKeys(Description);
        Thread.sleep(1000);
        createCampaignBtn.click();


    }

}
