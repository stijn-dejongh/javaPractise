package validation;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StringValidatorTest {

  @Test
  public void validate_errors_emptyInput() {
    String testString = "";

    List<String> result = new StringValidator().validate(testString);
    Assert.assertFalse(result.isEmpty());
    Assert.assertTrue(result.get(0).contains("may not be empty"));
  }

  @Test
  public void validate_errors_nullInput() {
    String testString = null;

    List<String> result = new StringValidator().validate(testString);
    Assert.assertFalse(result.isEmpty());
    Assert.assertTrue(result.get(0).contains("may not be empty"));
  }

  @Test
  public void validate_errors_badWord() {
    String testString = "fudging fudge";

    List<String> result = new StringValidator().validate(testString);
    Assert.assertFalse(result.isEmpty());
    Assert.assertTrue(result.get(0).contains("Input may not contain the F word"));
  }

  @Test
  public void validate_noErrors_normalInput() {
    String testString = "This is normal text";

    List<String> result = new StringValidator().validate(testString);
    Assert.assertTrue(result.isEmpty());
  }

  @Test
  public void isNotValid_whenEmpty() {
    String testString = "";
    Assert.assertFalse(new StringValidator().isValid(testString));
  }

  @Test
  public void isValid_normalInput() {
    String testString = "This is normal text";
    Assert.assertTrue(new StringValidator().isValid(testString));
  }

}