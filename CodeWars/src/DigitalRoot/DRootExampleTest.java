package DigitalRoot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class DRootExampleTest {

  @Test
  public void test16() {
    assertEquals("Fail on 16!", 7, DRoot.digital_root(16));
  }

  @Test
  public void test942() {
    assertEquals("Fail on 942!", 6, DRoot.digital_root(942));
  }

  @Test
  public void test132189() {
    assertEquals("Fail on 132189!", 6, DRoot.digital_root(132189));
  }

  @Test
  public void test493193() {
    assertEquals("Fail on 493193!", 2, DRoot.digital_root(493193));
  }

  @Test
  public void testLuckNumber() {
    assertEquals("Fail on 18121989!", 3, DRoot.digital_root(18121989));
  }
}