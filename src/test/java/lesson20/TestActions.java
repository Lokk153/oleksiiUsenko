package lesson20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActions {
    private static final Logger log = LogManager.getLogger(TestActions.class);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver;
        try {
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    log.info("Success - browser selected: " + driver);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    log.info("Success - browser selected: " + driver);
                    break;
                default:
                    throw new NullPointerException();
            }
            return driver;
        } catch (Exception e) {
            throw new NullPointerException("Fail - Unknown browser");
        }
    }

    public static void quitBrowser(WebDriver driver) {
        try {
            if (null != driver) {
                driver.quit();
                log.info("Success - quitBrowser: " + driver);
            } else {
                log.info("Unable to QUIT the Browser as Its NULL");
            }
        } catch (Exception e) {
            log.error(ANSI_RED + "Error quitBrowser: " + e.getCause() + ANSI_RESET);
        }
    }

    public static void getUrl(WebDriver driver, String url) {
        try {
            driver.get(url);
            log.info("Success - getUrl: " + url);
        } catch (Exception e) {
            log.error(ANSI_RED + "Error getUrl: " + url + " .Exception: " + e.getCause() + ANSI_RESET);
        }
    }

    public static void clickElement(WebDriver driver, By element) {
        try {
            driver.findElement(element).click();
            log.info("Success - clickElement: " + element);
        } catch (Exception e) {
            log.error(ANSI_RED + "Error - clickElement: " + element + " .Exception: " + e.getCause() + ANSI_RESET);
        }
    }

    public static void enterTextIntoElement(WebDriver driver, By element, String textToBeEntered) {
        try {
            driver.findElement(element).sendKeys(textToBeEntered);
            log.info("Success - enterTextIntoElement: " + element);
        } catch (Exception e) {
            log.error(ANSI_RED + "Error - enterTextIntoElement: " + element + " .Exception: " + e.getCause() + ANSI_RESET);
        }
    }

    public static void clearField(WebDriver driver, By element) {
        try {
            driver.findElement(element).clear();
            log.info("Success - clearField" + element);
        } catch (Exception e) {
            log.error(ANSI_RED + "Error - clearField: " + element + " .Exception: " + e.getCause() + ANSI_RESET);
        }
    }

    public static String selectTextFromElement(WebDriver driver, By element) {
        String text;
        try {
            text = driver.findElement(element).getText();
            log.info("Success - selectTextFromElement: " + element);
            return text;
        } catch (Exception e) {
            log.error(ANSI_RED + "Error - selectTextFromElement: " + element + " .Exception: " + e.getCause() + ANSI_RESET);
            throw new NullPointerException();
        }

    }
}
