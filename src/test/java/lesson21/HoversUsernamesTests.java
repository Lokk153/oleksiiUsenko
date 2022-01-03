package lesson21;

import TestActions.ActionsLogMessage;
import TestActions.BrowserActions;
import TestActions.CursorActions;
import TestActions.TextActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test(groups = {"lesson21"})
public class HoversUsernamesTests {

    @Test
    public void selectUsernames() {
        String methodName = getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName();
        ActionsLogMessage.getLogMessage(ActionsLogMessage.START_TEST, methodName);

        WebDriver driver = BrowserActions.getBrowser("chrome");
        BrowserActions.getUrl(driver, "https://the-internet.herokuapp.com/hovers");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[1][@class='figure']")));
        CursorActions.moveToElement(driver, By.xpath("//*/div[1][@class='figure']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[1]/div[1]/h5[1]")));
        System.out.println("Username: " + TextActions.selectTextFromElement(driver, By.xpath("//*/div[1]/div[1]/h5[1]")).substring(6));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[2][@class='figure']")));
        CursorActions.moveToElement(driver, By.xpath("//*/div[2][@class='figure']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[2]/div[1]/h5[1]")));
        System.out.println("Username: " + TextActions.selectTextFromElement(driver, By.xpath("//*/div[2]/div[1]/h5[1]")).substring(6));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[3][@class='figure']")));
        CursorActions.moveToElement(driver, By.xpath("//*/div[3][@class='figure']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[3]/div[1]/h5[1]")));
        System.out.println("Username: " + TextActions.selectTextFromElement(driver, By.xpath("//*/div[3]/div[1]/h5[1]")).substring(6));
        BrowserActions.quitBrowser(driver);

        ActionsLogMessage.getLogMessage(ActionsLogMessage.STOP_TEST, methodName);
    }
}
