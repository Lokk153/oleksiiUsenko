package pageObjects;

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

    //Page Methods
    public HomePage goToHomePage() {
        driver.get(homePageUrl);
        return this;
    }

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
}
