package lesson27;

import Tests.BaseSelenideTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageSelenideObjects.DynamicLoadingSelenidePage;

public class DynamicLoadingSelenideTests extends BaseSelenideTest {
    @Test
    public void dynamicLoadingSelenideTest() {
        DynamicLoadingSelenidePage getMessageValue = openAppSelenide()
                .goToDynamicLoadingSelenidePage()
                .clickExample1()
                .clickStartButton();

        String message = getMessageValue.getText();
        Assert.assertTrue(message.contains("Hello World!"));

    }
}
