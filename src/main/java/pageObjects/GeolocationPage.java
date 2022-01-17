package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeolocationPage extends BasePage {

    //Constructor
    public GeolocationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(xpath = "//button[contains(text(),'Where am I?')]")
    private WebElement whereButton;

    @FindBy(id = "lat-value")
    private WebElement latitude;

    @FindBy(id = "long-value")
    private WebElement longitude;

    //Page Methods
    public GeolocationPage clickWhereButton(){
        click(whereButton);
        return this;
    }

    public String getLatitude (){
        return selectTextFromElement(latitude);
    }

    public String getLongitude (){
        return selectTextFromElement(longitude);
    }
}
