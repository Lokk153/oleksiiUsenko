package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.HomePage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", new File("target/download").getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        this.driver = new ChromeDriver(options);


    }

    @AfterClass
    public void closeBrowser() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public HomePage homePage() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        return homePage;
    }
}
