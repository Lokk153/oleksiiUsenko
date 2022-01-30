package Tests;

import com.codeborne.selenide.Configuration;
import pageSelenideObjects.HomeSelenidePage;

import static com.codeborne.selenide.Selenide.open;

public class BaseSelenideTest {
    public static HomeSelenidePage openAppSelenide() {

        Configuration.downloadsFolder = "E:\\Personal dev\\javaProject\\oleksiiUsenko\\target\\download";
        Configuration.timeout = 10000;

        open("https://the-internet.herokuapp.com");
        return new HomeSelenidePage();
    }
}
