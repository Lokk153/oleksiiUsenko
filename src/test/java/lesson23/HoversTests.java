package lesson23;

import Tests.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HoversPage;

public class HoversTests extends BaseTest {

    @Test
    public void selectUsernames() {

        HoversPage hoversPage = homePage().goToHoversPage();
        String username1 = hoversPage.moveCursorToFirstAvatar().getFirstUsername().substring(6);
        System.out.println("Username: " + username1);

        String username2 = hoversPage.moveCursorToSecondAvatar().getSecondUsername().substring(6);
        System.out.println("Username: " + username2);

        String username3 = hoversPage.moveCursorToThirdAvatar().getThirdUsername().substring(6);
        System.out.println("Username: " + username3);
    }
}
