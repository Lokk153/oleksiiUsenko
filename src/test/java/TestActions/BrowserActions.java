package TestActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserActions {

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver;
        try {
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    String methodName =  BrowserActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
                    ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    methodName =  BrowserActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
                    ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
                    break;
                default:
                    throw new NullPointerException();
            }
            return driver;
        } catch (Exception e) {
            String methodName =  BrowserActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
            throw new NullPointerException("Unknown browser");
        }
    }

    public static void quitBrowser(WebDriver driver) {
        try {
            if (null != driver) {
                driver.quit();
                String methodName =  BrowserActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
                ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
            } else {
                String methodName =  BrowserActions.class.getName() + " " + Thread.currentThread().getStackTrace()[1].getMethodName();
                ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
            }
        } catch (Exception e) {
            String methodName =  BrowserActions.class.getName() + " " + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }

    public static void getUrl(WebDriver driver, String url) {
        try {
            driver.get(url);
            String methodName =  BrowserActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
        } catch (Exception e) {
            String methodName =  BrowserActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }
}
