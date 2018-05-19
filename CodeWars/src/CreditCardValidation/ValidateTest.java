package CreditCardValidation;

/**
 * Created by Stijn Dejongh on 19.05.18.
 * <p>
 * Code Wars Kata: https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2/train/java
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidateTest {

  @Test
  public void test891() {
    assertEquals(false, Validate.validate("891"));
  }

  @Test
  public void test2121() {
    assertEquals(true, Validate.validate("2121"));
  }

  @Test
  public void test26() {
    assertEquals(true, Validate.validate("26"));
  }

  @Test
  public void test91() {
    assertEquals(true, Validate.validate("26"));
  }

  @Test
  public void test2626262626262626() {
    assertEquals(true, Validate.validate("2626262626262626"));
  }
}
