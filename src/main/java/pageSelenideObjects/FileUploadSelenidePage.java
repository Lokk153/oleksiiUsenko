package pageSelenideObjects;

import com.codeborne.selenide.SelenideElement;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;

public class FileUploadSelenidePage {

    private final SelenideElement inputFile = $("#file-upload");
    private final SelenideElement uploadButton = $("#file-submit");

    public FileUploadSelenidePage uploadFileSelenide(File file) {
        inputFile.uploadFile(file);
        uploadButton.click();
        return this;
    }

}

