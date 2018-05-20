package permutations;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doji on 20.05.18.
 */
public class MiddlePermutationTest {

  @Test
  public void basicTests() {
    assertEquals("bac", MiddlePermutation.findMidPerm("abc"));
    assertEquals("bdca", MiddlePermutation.findMidPerm("abcd"));
    assertEquals("cbxda", MiddlePermutation.findMidPerm("abcdx"));
    assertEquals("cxgdba", MiddlePermutation.findMidPerm("abcdxg"));
    assertEquals("dczxgba", MiddlePermutation.findMidPerm("abcdxgz"));
  }

  @Test
  public void testABCD() {
    assertEquals("bdca", MiddlePermutation.findMidPerm("abcd"));
  }

  @Test
  public void testAssertionIssue() {
    MiddlePermutation.findMidPerm("jwzksqmguithrcyvonldfxpa");
  }

  @Test(timeout = 75)
  public void testLongInput() {
    MiddlePermutation.findMidPerm("sdgyehorqbjcmfvntux");
  }

  /*
  This test is left here intentionally to show the time complexity of the naive implementation
   */
  @Test
  public void testGenerateDictionary() {
    List<String> dictionary = MiddlePermutationNaive.generateDictionary(new String[]{"a", "b"});
    Assert.assertEquals("The dictionary length is invalid", 2, dictionary.size());
    Assert.assertEquals("ab", dictionary.get(0));
    Assert.assertEquals("ba", dictionary.get(1));
  }
}
