package pageSelenideObjects;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class FileDownloadSelenidePage {

    public File downloadFile(String filename) {
        try {
            return $(By.linkText(filename)).download();
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}

