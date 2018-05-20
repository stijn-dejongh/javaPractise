package sumofdivided;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by doji on 20.05.18.
 */
public class SumOfDividedTest {

  @Test
  public void testOne() {
    int[] lst = new int[]{12, 15};
    assertEquals("(2 12)(3 27)(5 15)",
        SumOfDivided.sumOfDivided(lst));
  }

  @Test
  public void testSumIsZero() {
    int[] lst = new int[]{15, 30, -45};
    String calucatedResult = SumOfDivided.sumOfDivided(lst);
    assertTrue(calucatedResult.length() > 0);
    assertTrue(calucatedResult.contains("(5 0)"));
  }
}
