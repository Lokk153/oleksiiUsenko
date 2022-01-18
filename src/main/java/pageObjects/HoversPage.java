package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage extends BasePage {

    //Constructor
    public HoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(xpath = "//*/div[1][@class='figure']")
    WebElement avatar1;

    @FindBy(xpath = "//*/div[2][@class='figure']")
    WebElement avatar2;

    @FindBy(xpath = "//*/div[3][@class='figure']")
    WebElement avatar3;

    @FindBy(xpath = "//*/div[1]/div[1]/h5[1]")
    WebElement username1;

    @FindBy(xpath = "//*/div[2]/div[1]/h5[1]")
    WebElement username2;

    @FindBy(xpath = "//*/div[3]/div[1]/h5[1]")
    WebElement username3;


    //Page Methods
    public HoversPage moveCursorToFirstAvatar() {
        moveToCursorElement(avatar1);
        return this;
    }

    public HoversPage moveCursorToSecondAvatar() {
        moveToCursorElement(avatar2);
        return this;
    }

    public HoversPage moveCursorToThirdAvatar() {
        moveToCursorElement(avatar3);
        return this;
    }

    public String getFirstUsername() {
        return selectTextFromElement(username1);
    }

    public String getSecondUsername() {
        return selectTextFromElement(username2);
    }

    public String getThirdUsername() {
        return selectTextFromElement(username3);
    }


}
