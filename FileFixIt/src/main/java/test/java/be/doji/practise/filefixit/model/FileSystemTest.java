package test.java.be.doji.practise.filefixit.model;

import be.doji.practise.filefixit.model.FileSystem;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Doji on 29/01/2017.
 */
public class FileSystemTest {

    private static final String REFERENCE_DIRECTORY = "/var/opt/test";

    @Test(expected=IllegalArgumentException.class)
    public void testAddDirectoryIllegalArgumentEmpty() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addDirectory("");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAddDirectoryIllegalArgumentNull() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addDirectory((String) null);
    }

    @Test
    public void testGetAmountOfRequiredCreates() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addDirectory(REFERENCE_DIRECTORY);
        int amountOfRequiredCreates = fileSystem.getAmountOfRequiredCreates("/var/opt/test/find/this");
        Assert.assertEquals(2, amountOfRequiredCreates);
    }




}
