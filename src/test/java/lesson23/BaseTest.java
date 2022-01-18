package lesson23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.HomePage;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterClass
    public void closeBrowser() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public HomePage homePage (){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        return homePage;
    }
}
