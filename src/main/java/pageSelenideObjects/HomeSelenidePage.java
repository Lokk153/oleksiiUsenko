package pageSelenideObjects;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class HomeSelenidePage {

    private final SelenideElement downloadFilePageButton = $("#content > ul > li:nth-child(17) > a");
    private final SelenideElement uploadFilePageButton = $("#content > ul > li:nth-child(18) > a");
    private final SelenideElement dynamicLoadingButton = $("#content > ul > li:nth-child(14) > a");

    public FileDownloadSelenidePage goToFileDownloadSelenidePage() {
        downloadFilePageButton.click();
        return new FileDownloadSelenidePage();
    }

    public FileUploadSelenidePage goToFileUploadSelenidePage() {
        uploadFilePageButton.click();
        return new FileUploadSelenidePage();
    }

    public DynamicLoadingSelenidePage goToDynamicLoadingSelenidePage() {
        dynamicLoadingButton.click();
        return new DynamicLoadingSelenidePage();
    }
}
