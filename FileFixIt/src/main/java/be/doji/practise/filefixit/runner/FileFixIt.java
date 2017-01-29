package be.doji.practise.filefixit.runner;

import be.doji.practise.filefixit.exception.FileProcessingException;
import be.doji.practise.filefixit.io.InputHandler;
import be.doji.practise.filefixit.model.Assignment;
import be.doji.practise.filefixit.util.FileUtils;
import org.junit.Assert;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doji on 29/01/2017.
 */
public class FileFixIt {

    private static final String INPUT_DIRECTORY = "input";
    private static final String INPUT_FILE_NAME = "A-small-practice.in";
    private static final String OUTPUT_DIRECTORY = "output";

    public static void main(String[] args) {
        try {
            InputHandler handler = new InputHandler();
            List<Assignment> assignments = handler.parseFile(getFilePath(INPUT_DIRECTORY + "/" + INPUT_FILE_NAME));
            List<String> outputLines = new ArrayList<>();
            for(Assignment assignment : assignments) {
                outputLines.add("Case #"+assignment.getId()+": "+assignment.getSolution());
            }
            FileUtils.writeLinesToFile(outputLines, getFilePath(OUTPUT_DIRECTORY).toString()+ "/" + INPUT_FILE_NAME);
        } catch (FileProcessingException e) {
            e.printStackTrace();
        }
    }

    private static Path getFilePath(String location) {
        File file = new File(FileFixIt.class.getClassLoader().getResource(location).getFile());
        Assert.assertTrue(file.exists());
        return Paths.get(file.getPath());
    }
}
