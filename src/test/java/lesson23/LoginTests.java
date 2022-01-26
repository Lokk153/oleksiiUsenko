package lesson23;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SecurePage;

public class LoginTests extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] users() {
        String[][] users = {
                {"tomsmith", "SuperSecretPassword!"}
        };
        return users;
    }

    @Test(dataProvider = "users")
    public void loginCorrect(String username, String userPassword) {

        LoginPage loginPage = homePage().goToLoginPage();
        loginPage
                .setUsername(username)
                .setPassword(userPassword)
                .clickLoginButton();

        SecurePage securePage = new SecurePage(driver);
        String alertText = securePage
                .getAlertMessage();
        Assert.assertTrue(alertText.contains("You logged into a secure area!"));
    }

    @Test(dataProvider = "users")
    public void loginEmptyFields(String userName, String userPassword) {
        LoginPage loginPage = homePage().goToLoginPage();

        String alertMessage = loginPage
                .setPassword(userPassword)
                .clickLoginButton()
                .getAlertMessage();
        Assert.assertTrue(alertMessage.contains("Your username is invalid!"));

        alertMessage = loginPage
                .clearFieldPassword()
                .setUsername(userName)
                .clickLoginButton()
                .getAlertMessage();
        Assert.assertTrue(alertMessage.contains("Your password is invalid!"));

    }

}
