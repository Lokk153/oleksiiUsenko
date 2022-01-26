package File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileObject {

    public FileObject getAbsoluteFile(String fileDirectory) {
        new File(fileDirectory).getAbsoluteFile();
        return this;
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