package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChallengingDomPage extends BasePage {

    //Constructor
    public ChallengingDomPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(xpath = "//a[@class = 'button']")
    WebElement button;

    @FindBy(xpath = "//a[@class = 'button alert']")
    WebElement buttonAlert;

    @FindBy(xpath = "//a[@class = 'button success']")
    WebElement buttonSuccess;

    @FindBy(xpath = "//td[contains(text(),'Definiebas')]")
    List<WebElement> list;


    //Page Methods
    public ChallengingDomPage clickButton() {
        click(button);
        return this;
    }

    public ChallengingDomPage clickButtonAlert() {
        click(buttonAlert);
        return this;
    }

    public ChallengingDomPage clickButtonSuccess() {
        click(buttonSuccess);
        return this;
    }

    public void printList() {
        System.out.print("Values: ");
        for (WebElement e : list) {
            System.out.print(e.getText() + " ");
        }
        System.out.println();
    }
}
