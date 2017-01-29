package be.doji.practise.filefixit.model;

import be.doji.practise.filefixit.exception.NoParentFoundException;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doji on 29/01/2017.
 * <p>
 * Class representing the computers file system.
 * This class is responsible for tracking all the directories that exist on a file system.
 */
public class FileSystem {

    private List<Path> existingDirectories;

    public FileSystem() {
        this.existingDirectories = new ArrayList<>();
    }

    public FileSystem(List<Path> directoriesToAdd) {
        this();
        if (directoriesToAdd != null) {
            this.existingDirectories = new ArrayList<>(directoriesToAdd);
        }
    }

    public ArrayList<Path> getExistingDirectories() {
        return new ArrayList<>(existingDirectories);
    }

    public void addDirectory(String directory) {
        if (isNotBlank(directory)) {
            addDirectory(Paths.get(directory));
        } else {
            throw new IllegalArgumentException("You passed an empty or null directory to the filesystem");
        }
    }

    public void addDirectory(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("You tried to ad 'null' to the directories managed by the filesystem");
        }
        for (Path parent = Paths.get(path.toString()); parent != null; parent = parent.getParent()) {
            addDirectoryIfNotManaged(parent);
        }
    }

    private void addDirectoryIfNotManaged(Path parent) {
        if (!existingDirectories.contains(parent)) {
            existingDirectories.add(parent);
        }
    }

    public int getAmountOfRequiredCreates(String directory) {
        try {
            Path directoryPath = Paths.get(directory);
            Path relativePath = directoryPath.relativize(getClosestParent(directoryPath));
            return StringUtils.countMatches(relativePath.toString(), "..");
        } catch (NoParentFoundException e) {
            return StringUtils.countMatches(directory, "/") + 1;
        }
    }

    private Path getClosestParent(Path directory) throws NoParentFoundException {
        for (Path parent = directory; parent != null; parent = parent.getParent()) {
            if (existingDirectories.contains(parent)) {
                return parent;
            }
        }
        throw new NoParentFoundException("Could not find a currently known parent on the FileSystem");
    }

    private boolean isNotBlank(String stringToCheck) {
        return stringToCheck != null && !stringToCheck.isEmpty();
    }
}
