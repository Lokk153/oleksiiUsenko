package lesson26;

import File.FileObject;
import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FileUploadPage;

public class FileUploadTests extends BaseTest {

    @Test
    public void uploadFileTest() {
        FileUploadPage fileUploadPage = homePage()
                .goToFileUploadPage()
                .sendNameFile("target/download/some-file.txt")
                .clickUploadButton();

        Assert.assertTrue(fileUploadPage.getSuccessMessage().contains("File Uploaded!"));
    }

    @Test
    public void downloadChangedFile () {
        homePage()
                .goToFileDownloadPage()
                .clickFileName()
                .waitForFileDownload("some-file.txt");

        new FileObject()
                .getAbsoluteFile("target/download/some-file.txt")
                .setValue("target/download/some-file.txt", "new Value");

        FileUploadPage fileUploadPage = homePage()
                .goToFileUploadPage()
                .sendNameFile("target/download/some-file.txt")
                .clickUploadButton();

        Assert.assertTrue(fileUploadPage.getSuccessMessage().contains("File Uploaded!"));
    }
}

