package lesson26;

import Tests.BaseTest;
import org.testng.annotations.Test;

public class FileDownloadTests extends BaseTest {

    @Test
    public void downloadTest() {
        homePage()
                .goToFileDownloadPage()
                .clickFileName()
                .waitForFileDownload("some-file.txt");
    }
}
