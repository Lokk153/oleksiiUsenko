package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".flash.error")
    private WebElement errorAlert;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement alertMessage;

    //Page Methods
    @Step("setUsername")
    public LoginPage setUsername(String username){
        enterTextIntoElement(usernameInput, username);
        return this;
    }

    @Step("setPassword")
    public LoginPage setPassword(String password){
        enterTextIntoElement(passwordInput, password);
        return this;
    }

    @Step("clickLoginButton")
    public LoginPage clickLoginButton(){
        click(loginButton);
        return this;
    }


    public String getAlertMessage() {
        return selectTextFromElement(alertMessage);
    }

    @Step("clearFieldUsername")
    public LoginPage clearFieldUsername(){
        clearField(usernameInput);
        return this;
    }

    @Step("clearFieldPassword")
    public LoginPage clearFieldPassword(){
        clearField(passwordInput);
        return this;
    }

}
