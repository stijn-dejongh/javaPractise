package be.doji.practise.filefixit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doji on 29/01/2017.
 */
public class Assignment {

    private int id;
    private List<String> existingDirectories;
    private List<String> directoriesToCreate;

    public Assignment(int id) {
        this.existingDirectories = new ArrayList<>();
        this.directoriesToCreate = new ArrayList<>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getExistingDirectories() {
        return existingDirectories;
    }

    public void setExistingDirectories(List<String> existingDirectories) {
        this.existingDirectories = existingDirectories;
    }

    public List<String> getDirectoriesToCreate() {
        return directoriesToCreate;
    }

    public void setDirectoriesToCreate(List<String> directoriesToCreate) {
        this.directoriesToCreate = directoriesToCreate;
    }

    public void addExistingDirectory(String directory) {
        this.existingDirectories.add(directory);
    }

    public void addDirectoryToEvaluate(String directory) {
        this.directoriesToCreate.add(directory);
    }

    public void addExistingDirectories(List<String> directories) {
        this.existingDirectories.addAll(directories);
    }

    public void addDirectoriesToEvaluate(List<String> directories) {
        this.directoriesToCreate.addAll(directories);
    }
}
