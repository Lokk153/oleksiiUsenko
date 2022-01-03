package TestActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickActions {

    public static void click(WebDriver driver, By element) {
        try {
            driver.findElement(element).click();
            String methodName =  ClickActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
        } catch (Exception e) {
            String methodName =  ClickActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }

    public static void dragAndDrop(WebDriver driver, By source, By target) {
        try {
            WebElement sourceElement = driver.findElement(source);
            WebElement targetElement = driver.findElement(target);
            Actions builder = new Actions(driver);
            builder.dragAndDrop(sourceElement, targetElement).perform();
            String methodName =  ClickActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
        } catch (Exception e) {
            String methodName =  ClickActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }
}
