package lesson21;

import TestActions.ActionsLogMessage;
import TestActions.BrowserActions;
import TestActions.ClickActions;
import TestActions.TextActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(groups = {"lesson21"})
public class DragAndDropTests {

    @Test
    public void dragAndDropTest() {
        String methodName = getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
        ActionsLogMessage.getLogMessage(ActionsLogMessage.START_TEST, methodName);

        WebDriver driver = BrowserActions.getBrowser("chrome");
        BrowserActions.getUrl(driver, "https://crossbrowsertesting.github.io/drag-and-drop.html");
        ClickActions.dragAndDrop(driver, By.xpath("//p[contains(text(),'Drag me to my target')]"), By.xpath("//div[@id='droppable']"));
        Assert.assertEquals(TextActions.selectTextFromElement(driver, By.xpath("//p[contains(text(),'Dropped!')]")), "Dropped!");
        BrowserActions.quitBrowser(driver);

        ActionsLogMessage.getLogMessage(ActionsLogMessage.STOP_TEST, methodName);
    }
}
