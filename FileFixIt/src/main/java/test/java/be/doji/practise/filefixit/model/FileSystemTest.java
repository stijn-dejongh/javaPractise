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
    public void testGetAmountOfRequiredCreatesSubDirectory() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addDirectory(REFERENCE_DIRECTORY);
        int amountOfRequiredCreates = fileSystem.getAmountOfRequiredCreates("/var/opt/test/find/this");
        Assert.assertEquals(2, amountOfRequiredCreates);
    }

    @Test
    public void testGetAmountOfRequiredCreatesIdenticalDirectory() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addDirectory(REFERENCE_DIRECTORY);
        int amountOfRequiredCreates = fileSystem.getAmountOfRequiredCreates("/var/opt/test");
        Assert.assertEquals(0, amountOfRequiredCreates);
    }

    @Test
    public void testGetAmountOfRequiredCreatesSiblingDirectory() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addDirectory(REFERENCE_DIRECTORY);
        int amountOfRequiredCreates = fileSystem.getAmountOfRequiredCreates("/var/opt/lol");
        Assert.assertEquals(1, amountOfRequiredCreates);
    }

    @Test
    public void testGetAmountOfRequiredCreatesDifferentRootDirectory() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.addDirectory(REFERENCE_DIRECTORY);
        int amountOfRequiredCreates = fileSystem.getAmountOfRequiredCreates("/home/doji/coding/practise");
        Assert.assertEquals(4, amountOfRequiredCreates);
    }
}
