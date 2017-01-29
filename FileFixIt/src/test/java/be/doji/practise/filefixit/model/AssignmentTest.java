package be.doji.practise.filefixit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Doji on 29/01/2017.
 */
public class AssignmentTest {

    @Test
    public void testGetSolutionNoOverlap() {
        Assignment assignment = new Assignment(1);
        assignment.addExistingDirectory("/var/opt/test");
        assignment.addDirectoryToEvaluate("/home/doji/test");
        Assert.assertEquals(3, assignment.getSolution());
    }

    @Test
    public void testGetSolutionNoExistingDirectories() {
        Assignment assignment = new Assignment(1);
        assignment.addDirectoryToEvaluate("/home/gcj/finals");
        assignment.addDirectoryToEvaluate("/home/gcj/quals");
        Assert.assertEquals(4, assignment.getSolution());
    }

    @Test
    public void testGetSolutionNesting() {
        Assignment assignment = new Assignment(1);
        assignment.addExistingDirectory("/chicken");
        assignment.addExistingDirectory("/chicken/egg");
        assignment.addDirectoryToEvaluate("/chicken");
        Assert.assertEquals(0, assignment.getSolution());
    }

    @Test
    public void testGetSolutionMixed() {
        Assignment assignment = new Assignment(1);
        assignment.addExistingDirectory("/a");
        assignment.addDirectoryToEvaluate("/a/b");
        assignment.addDirectoryToEvaluate("/a/c");
        assignment.addDirectoryToEvaluate("/b/b");
        Assert.assertEquals(4, assignment.getSolution());
    }

}
