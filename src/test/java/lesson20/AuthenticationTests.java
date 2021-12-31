package lesson20;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
public class AuthenticationTests extends TestActions {
    private static final Logger log = LogManager.getLogger(AuthenticationTests.class);

    @DataProvider(name = "users")
    public Object[][] users() {
        String[][] users = {
                {"tomsmith", "SuperSecretPassword!"}
        };
        return users;
    }

    @Test(groups = {"Authentication", "lesson20"}, dataProvider = "users")
    public void loginCorrect(String userName, String userPassword) {

        log.info("Start test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
        WebDriver driver = getBrowser("chrome");

        getUrl(driver, "https://the-internet.herokuapp.com/login");
        clickElement(driver, By.xpath("//input[@id='username']"));
        enterTextIntoElement(driver, By.xpath("//input[@id='username']"), userName);
        clickElement(driver, By.xpath("//input[@id='password']"));
        enterTextIntoElement(driver, By.xpath("//input[@id='password']"), userPassword);
        clickElement(driver, By.xpath("//i[contains(text(),'Login')]"));
        Assert.assertTrue(selectTextFromElement(driver, By.xpath("//div[@id='flash']")).contains("You logged into a secure area!"));

        quitBrowser(driver);
        log.info("Stop test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test(groups = {"Authentication", "lesson20"}, dataProvider = "users")
    public void loginEmptyFields(String userName, String userPassword) {
        log.info("Start test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
        WebDriver driver = getBrowser("chrome");
        getUrl(driver, "https://the-internet.herokuapp.com/login");

        //username
        clickElement(driver, By.xpath("//input[@id='password']"));
        enterTextIntoElement(driver, By.xpath("//input[@id='password']"), userPassword);
        clickElement(driver, By.xpath("//i[contains(text(),'Login')]"));
        Assert.assertTrue(selectTextFromElement(driver, By.xpath("//div[@id='flash']")).contains("Your username is invalid!"));
        clearField(driver, By.xpath("//input[@id='password']"));

        //password
        clickElement(driver, By.xpath("//input[@id='username']"));
        enterTextIntoElement(driver, By.xpath("//input[@id='username']"), userName);
        clickElement(driver, By.xpath("//i[contains(text(),'Login')]"));
        Assert.assertTrue(selectTextFromElement(driver, By.xpath("//div[@id='flash']")).contains("Your password is invalid!"));

        quitBrowser(driver);
        log.info("Stop test - " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}

