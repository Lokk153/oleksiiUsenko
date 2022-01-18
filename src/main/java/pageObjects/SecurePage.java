package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage {

    //Constructor
    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement alertText;

    //private final By alertTextBy = By.xpath("//div[@id='flash']");

    //Page Methods
    public String getAlertMessage() {
        return selectTextFromElement(alertText);
    }
}
