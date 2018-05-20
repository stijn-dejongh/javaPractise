package bracechecker;

import static org.junit.Assert.*;
import org.junit.Test;

public class BraceCheckerTests {

  private BraceChecker checker = new BraceChecker();

  @Test
  public void testValid() {
    assertEquals(true, checker.isValid("()"));
  }

  @Test
  public void testEmpty() {
    assertEquals(true, checker.isValid(""));
  }

  @Test
  public void testOnlyOpen() {
    assertEquals(false, checker.isValid("([{"));
  }

  @Test
  public void testOnlyClose() {
    assertEquals(false, checker.isValid(")"));
  }

  @Test
  public void testValidAssignmentOne() {
    assertEquals(true, checker.isValid("(){}[]"));
  }

  @Test
  public void testValidAssignmentTwo() {
    assertEquals(true, checker.isValid("([{}])" ));
  }

  @Test
  public void testValidAssignmentThree() {
    assertEquals(false, checker.isValid("(}"  ));
  }

  @Test
  public void testValidAssignmentFour() {
    assertEquals(false, checker.isValid("[({})](]"  ));
  }

  @Test
  public void testMace() {
    assertEquals(false, checker.isValid("()[]{)"));
  }

  @Test
  public void testStijn() {
    assertEquals(true, checker.isValid("()[]{()[{}(()[])]}"));
  }

  @Test
  public void testInvalid() {
    assertEquals(false, checker.isValid("[(])"));
  }



}
