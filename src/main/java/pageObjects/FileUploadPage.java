package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage extends BasePage {

    //Constructor
    public FileUploadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(css = "#file-upload")
    public WebElement selectFileButton;

    @FindBy(css = "#file-submit")
    private WebElement uploadButton;

    @FindBy(css = "#content > div > h3")
    private WebElement successMessage;

    @Step("clickUploadButton")
    public FileUploadPage clickUploadButton() {
        click(uploadButton);
        return this;
    }

    @Step("getSuccessMessage")
    public String getSuccessMessage() {
        return selectTextFromElement(successMessage);
    }

    @Step("sendNameFile")
    public FileUploadPage sendNameFile(String path){
        uploadFile(selectFileButton, path);
        return this;
    }

}