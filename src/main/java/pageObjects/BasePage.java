package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, TIMEOUT, POLLING);
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    //Page Methods
    protected void waitVisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    //Click Actions
    protected void click(WebElement element) {
        waitVisibility(element);
        element.click();
    }

    protected void dragAndDrop(WebElement source, WebElement target) {
        waitVisibility(source);
        waitVisibility(target);
        actions.dragAndDrop(source, target).perform();
    }

    //Text Actions
    protected void enterTextIntoElement(WebElement element, String textToBeEntered) {
        waitVisibility(element);
        element.sendKeys(textToBeEntered);
    }

    protected String selectTextFromElement(WebElement element) {
        waitVisibility(element);
        return element.getText();
    }

    protected void clearField(WebElement element) {
        element.clear();
    }

    //Cursor Actions
    protected void moveToCursorElement(WebElement target) {
        actions.moveToElement(target).perform();
    }
}
