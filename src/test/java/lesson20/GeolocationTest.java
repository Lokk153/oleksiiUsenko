package lesson20;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class GeolocationTest extends TestActions {
    private static final Logger log = LogManager.getLogger(GeolocationTest.class);

    @Test(groups = {"lesson20"})
    public void getGeolocation() {


        log.info("Start test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
        WebDriver driver = getBrowser("chrome");

        getUrl(driver, "https://the-internet.herokuapp.com/geolocation");
        clickElement(driver, By.xpath("//button[contains(text(),'Where am I?')]"));

        try {
            var webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='lat-value']")));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='long-value']")));
            driver.switchTo().alert().accept();
            System.out.println("Alert is Displayed");
        } catch (NoAlertPresentException ex) {
            System.out.println("Alert is NOT Displayed");
        }

        System.out.println("Latitude: " + selectTextFromElement(driver, By.xpath("//div[@id='lat-value']")) +
                " Longitude: " + selectTextFromElement(driver, By.xpath("//div[@id='long-value']")));

        quitBrowser(driver);
        log.info("Stop test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
