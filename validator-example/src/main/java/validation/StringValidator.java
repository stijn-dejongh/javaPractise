package validation;

import java.util.List;

public class StringValidator extends Validator<String> {

  @Override
  public List<String> validate(String toValidate) {
    return new ValidationResult<>(toValidate)
        .validationStep(this::isNotEmpty, "Input may not be empty")
        .validationStep(this::doesNotContainBadWord, "Input may not contain the F word")
        .getValidationErrors();
  }

  private boolean isNotEmpty(String s) {
    return s != null && s.length() > 0;
  }

  private boolean doesNotContainBadWord(String s) {
    return s != null && !s.toUpperCase().contains("FUDGE");
  }

}
