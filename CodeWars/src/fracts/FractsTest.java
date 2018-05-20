package fracts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FractsTest {

  @Test
  public void testFractions() {
    long[][] lst;
    lst = new long[][]{{1, 2}, {1, 3}, {1, 4}};
    assertEquals("(6,12)(4,12)(3,12)", Fracts.convertFrac(lst));
  }
}
