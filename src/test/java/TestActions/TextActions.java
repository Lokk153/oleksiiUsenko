package TestActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextActions {

    public static void enterTextIntoElement(WebDriver driver, By element, String textToBeEntered) {
        try {
            driver.findElement(element).sendKeys(textToBeEntered);
            String methodName =  TextActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
        } catch (Exception e) {
            String methodName =  TextActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }

    public static String selectTextFromElement(WebDriver driver, By element) {
        String text;
        try {
            text = driver.findElement(element).getText();
            String methodName =  TextActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
            return text;
        } catch (Exception e) {
            String methodName =  TextActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
            throw new NullPointerException();
        }
    }

    public static void clearField(WebDriver driver, By element) {
        try {
            driver.findElement(element).clear();
            String methodName =  TextActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.PASS, methodName);
        } catch (Exception e) {
            String methodName =  TextActions.class.getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
            String exceptionData = e.getCause().getMessage();
            ActionsLogMessage.getLogMessage(ActionsLogMessage.FAIL, methodName, exceptionData);
        }
    }


}
