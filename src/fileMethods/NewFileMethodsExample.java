package fileMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFileMethodsExample {
    public static void main(String[] args) {
        try {
            Path path = Files.createTempFile("temp",".txt");
            // Write to file
            Files.writeString(path,"Hello World");
            // Read from file
            String content = Files.readString(path);
            System.out.println("File Content : " + content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
