package be.doji.practise.filefixit.io;

import be.doji.practise.filefixit.exception.FileProcessingException;
import be.doji.practise.filefixit.model.Assignment;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Doji on 29/01/2017.
 */
public class InputHandlerTest {

    @Test
    public void testParseFileAmount() throws FileProcessingException {
        InputHandler handler = new InputHandler();
        List<Assignment> parsedAssignments = handler.parseFile(getInputFile("io/baseInput.txt"));
        Assert.assertEquals(3, parsedAssignments.size());
    }

    @Test
    public void testParseFileAmountDoubleDigitBug() throws FileProcessingException {
        InputHandler handler = new InputHandler();
        List<Assignment> parsedAssignments = handler.parseFile(getInputFile("io/baseInputDoubleDigitLines.txt"));
        Assert.assertEquals(4, parsedAssignments.size());
    }

    @Test
    public void testParseFileContent() throws FileProcessingException {
        InputHandler handler = new InputHandler();
        List<Assignment> parsedAssignments = handler.parseFile(getInputFile("io/baseInput.txt"));
        Assert.assertEquals(3, parsedAssignments.size());

        assertAssignmentContents(parsedAssignments.get(0), 0, 2);
        assertAssignmentContents(parsedAssignments.get(1), 2, 1);
        assertAssignmentContents(parsedAssignments.get(2), 1, 3);
    }

    private void assertAssignmentContents(Assignment assignment, int amountOfExistingDirectories, int amountOfDirectoriesToCreate) {
        Assert.assertEquals(amountOfExistingDirectories, assignment.getExistingDirectories().size());
        Assert.assertEquals(amountOfDirectoriesToCreate, assignment.getDirectoriesToCreate().size());
    }

    private Path getInputFile(String location) {
        File inputFileLocation = new File(getClass().getClassLoader().getResource(location).getFile());
        Assert.assertTrue(inputFileLocation.exists());
        return Paths.get(inputFileLocation.getPath());
    }
}
