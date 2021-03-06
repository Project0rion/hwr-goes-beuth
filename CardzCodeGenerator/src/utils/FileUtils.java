package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Project0rion on 12.11.2016.
 */
public class FileUtils {

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static void writeFile(String path, Iterable<? extends CharSequence> text) throws IOException {
        Path file = Paths.get(path);

        File directory = new File(file.toAbsolutePath().toString());
        if (!directory.exists())
            directory.getParentFile().mkdirs();

        Files.write(file, text, StandardCharsets.UTF_8);
    }
}
