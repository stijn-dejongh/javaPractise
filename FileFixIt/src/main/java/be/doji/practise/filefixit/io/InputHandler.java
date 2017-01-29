package be.doji.practise.filefixit.io;

import be.doji.practise.filefixit.exception.FileProcessingException;
import be.doji.practise.filefixit.model.Assignment;
import be.doji.practise.filefixit.util.FileUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doji on 29/01/2017.
 */
public class InputHandler {

    private List<String> lines;
    private int assignmentCounter = 1;
    private int currentLineCounter = 1;

    public InputHandler() {
        this.lines = new ArrayList<>();
    }

    public List<Assignment> parseFile(Path fileLocation) throws FileProcessingException {
        List<Assignment> assignments = new ArrayList<>();
        lines = FileUtils.readFileLines(fileLocation);

        while (currentLineCounter < lines.size()) {
            int amountofExistingDirectory = Integer.parseInt(String.valueOf(lines.get(currentLineCounter).charAt(0)));
            int amountofDirectoriesToEvaluate = Integer
                    .parseInt(String.valueOf(lines.get(currentLineCounter).charAt(2)));
            currentLineCounter++;
            assignments.add(createAssignment(amountofExistingDirectory, amountofDirectoriesToEvaluate));
        }

        return assignments;
    }

    private Assignment createAssignment(int amountofExistingDirectory, int amountofDirectoriesToEvaluate) {
        Assignment assignment = new Assignment(assignmentCounter);
        assignment.addExistingDirectories(processDirectoryLines(amountofExistingDirectory));
        assignment.addDirectoriesToEvaluate(processDirectoryLines(amountofDirectoriesToEvaluate));
        return assignment;
    }

    private List<String> processDirectoryLines(int amountofExistingDirectory) {
        List<String> directories = new ArrayList<>();
        for (int j = currentLineCounter; j < currentLineCounter + amountofExistingDirectory; j++) {
            directories.add(lines.get(j));
        }
        currentLineCounter += amountofExistingDirectory;
        return directories;
    }
}
