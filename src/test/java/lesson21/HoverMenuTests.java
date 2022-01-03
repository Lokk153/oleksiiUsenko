package lesson21;

import TestActions.ActionsLogMessage;
import TestActions.BrowserActions;
import TestActions.CursorActions;
import TestActions.TextActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"lesson21"})
public class HoverMenuTests {

    @Test
    public void hoverMenuSelect() {
        String methodName = getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
        ActionsLogMessage.getLogMessage(ActionsLogMessage.START_TEST, methodName);

        WebDriver driver = BrowserActions.getBrowser("chrome");
        BrowserActions.getUrl(driver, "https://crossbrowsertesting.github.io/hover-menu.html");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[3][contains(@class, 'dropdown')]")));

        CursorActions.moveToElement(driver, By.xpath("//li[3][contains(@class, 'dropdown')]"));
        CursorActions.moveToElement(driver, By.xpath("//*[contains(@class, 'secondary-dropdown')]"));
        CursorActions.moveToElementClick(driver, By.xpath("//*[contains(@class, 'dropdown-menu secondary')]"));
        Assert.assertTrue(TextActions.selectTextFromElement(driver, By.xpath("//*[contains(@class, 'jumbotron secondary-clicked')]")).contains("Secondary Page"));
        BrowserActions.quitBrowser(driver);

        ActionsLogMessage.getLogMessage(ActionsLogMessage.STOP_TEST, methodName);
    }


}
