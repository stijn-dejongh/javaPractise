package be.doji.practise.filefixit.util;

import be.doji.practise.filefixit.exception.FileProcessingException;
import com.sun.javafx.binding.StringFormatter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author doji
 */
public final class FileUtils {

    // Utility classes should not have default or public constructors
    private FileUtils() {
    }

    public static List<String> readFileLines(Path fileLocation) throws FileProcessingException {
        try {
            return Files.lines(fileLocation).collect(Collectors.toList());
        } catch (IOException e) {
            String errorMessage = StringFormatter
                    .format("Something went wrong while reading the file %s", fileLocation.getFileName()).toString();
            throw new FileProcessingException(errorMessage, e);
        }
    }

    public static List<String> readFileLines(String absoluteFilePath) throws FileProcessingException {
        return readFileLines(Paths.get(absoluteFilePath));
    }

    public static List<String> readFileLines(File file) throws FileProcessingException {
        return readFileLines(file.getAbsolutePath());
    }

    public static Path writeLinesToFile(List<String> lines, String fileLocation) throws FileProcessingException {
        try {
            Path filePath = Paths.get(fileLocation);
            if (!filePath.toFile().exists()) {
                Files.createFile(filePath);
            }
            Files.write(filePath, lines, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING);
            return filePath;
        } catch (IOException e) {
            String errorMessage = StringFormatter
                    .format("Something went wrong while writing to the file %s", fileLocation).toString();
            throw new FileProcessingException(errorMessage, e);
        }
    }

}
