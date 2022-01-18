package lesson23;

import org.testng.annotations.Test;

public class ChallengingDomTests extends BaseTest {

    @Test
    public void selectValue() {
        homePage()
                .goToChallengingDomPage()
                .clickButton()
                .clickButtonAlert()
                .clickButtonSuccess()
                .printList();
    }
}
