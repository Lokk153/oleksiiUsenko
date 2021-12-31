package lesson20;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

@Test
public class SelectValueTest extends TestActions {
    private static final Logger log = LogManager.getLogger(SelectValueTest.class);

    @Test(groups = {"lesson20"})
    public void selectValue() {
        log.info("Start test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
        WebDriver driver = getBrowser("chrome");
        getUrl(driver, "https://the-internet.herokuapp.com/challenging_dom");

        clickElement(driver, By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
        clickElement(driver, By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]"));
        clickElement(driver, By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]"));

        List<WebElement> list = driver.findElements(By.xpath("//td[contains(text(),'Definiebas')]"));

        System.out.print("Values: ");
        for (WebElement e : list) {System.out.print(e.getText() + " ");}
        System.out.println();

        quitBrowser(driver);
        log.info("Stop test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
