package pageSelenideObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DynamicLoadingSelenidePage {

    private final SelenideElement example1 = $("#content > div > a:nth-child(5)");
    private final SelenideElement startButton = $("#start > button");
    private final SelenideElement message = $("#finish");

    public DynamicLoadingSelenidePage clickExample1() {
        example1.click();
        return new DynamicLoadingSelenidePage();
    }

    public DynamicLoadingSelenidePage clickStartButton() {
        startButton.shouldBe(Condition.visible).click();
        return this;
    }

    public String getText() {
        return message.shouldBe(Condition.visible).getText();
    }

}
