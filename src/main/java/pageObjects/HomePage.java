package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Page Variables
    String homePageUrl = "https://the-internet.herokuapp.com/";

    //Web Elements
    By formAuthentication = By.linkText("Form Authentication");
    By geolocation = By.linkText("Geolocation");
    By challengingDom = By.linkText("Challenging DOM");
    By hovers = By.linkText("Hovers");
    By fileDownload = By.linkText("File Download");
    By fileUpload = By.linkText("File Upload");

    //Page Methods
    public HomePage goToHomePage() {
        driver.get(homePageUrl);
        return this;
    }

    @Step("goToLoginPage")
    public LoginPage goToLoginPage() {
        driver.findElement(formAuthentication).click();
        return new LoginPage(driver);
    }

    public GeolocationPage goToGeolocationPage() {
        driver.findElement(geolocation).click();
        return new GeolocationPage(driver);
    }

    public ChallengingDomPage goToChallengingDomPage() {
        driver.findElement(challengingDom).click();
        return new ChallengingDomPage(driver);
    }

    public HoversPage goToHoversPage() {
        driver.findElement(hovers).click();
        return new HoversPage(driver);
    }

    public FileDownloadPage goToFileDownloadPage () {
        driver.findElement(fileDownload).click();
        return new FileDownloadPage(driver);
    }

    public FileUploadPage goToFileUploadPage() {
        driver.findElement(fileUpload).click();
        return new FileUploadPage(driver);
    }


}