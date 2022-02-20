package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloadPage extends BasePage {

    //Constructor
    public FileDownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(linkText = "some-file.txt")
    private WebElement fileItem;

    //Page Methods
    @Step("clickFileName")
    public FileDownloadPage clickFileName() {
        click(fileItem);
        return this;
    }


    public void waitForFileDownload(String fileName) {
        int attemp = 0;
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (++attemp > 10) {
                throw new RuntimeException("File is not downloaded");
            }
        } while (!new File("target/download/" + fileName).exists());
    }
}


