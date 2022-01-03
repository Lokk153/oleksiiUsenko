package TestActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CursorActions {

    public static void moveToElement(WebDriver driver, By target) {
        try {
            Actions actions = new Actions(driver);
            WebElement targetElement = driver.findElement(target);
            actions.moveToElement(targetElement).perform();

            String methodName =  CursorActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
        } catch (Exception e) {
            String methodName =  CursorActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }

    public static void moveToElementClick(WebDriver driver, By target) {
        try {
            Actions actions = new Actions(driver);
            WebElement targetElement = driver.findElement(target);
            actions.moveToElement(targetElement).click().perform();

            String methodName =  CursorActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
        } catch (Exception e) {
            String methodName =  CursorActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }
}
