package lesson27;

import Tests.BaseSelenideTest;
import org.testng.annotations.Test;
import pageSelenideObjects.FileDownloadSelenidePage;
import pageSelenideObjects.FileUploadSelenidePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUploadSelenideTests extends BaseSelenideTest {
    @Test
    public void downloadFileTestSelenide() {
        FileDownloadSelenidePage fileDownloadSelenidePage = openAppSelenide()
                .goToFileDownloadSelenidePage();

        File downloadFile = fileDownloadSelenidePage
                .downloadFile("some-file.txt");

        setValue("target/download/some-file.txt", "new Value");

        FileUploadSelenidePage fileUploadSelenidePage = openAppSelenide()
                .goToFileUploadSelenidePage()
                .uploadFileSelenide(downloadFile);
    }

    public void setValue(String fileDirectory, String value) {
        try {
            Path path = Paths.get(fileDirectory);

            Files.writeString(path, value, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
