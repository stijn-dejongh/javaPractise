package validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class Validator<T> {

  public abstract List<String> validate(T toValidate);

  public boolean isValid(T toValidate) {
    return this.validate(toValidate).isEmpty();
  }


  protected class ValidationResult<T> {

    private final T toValidate;
    private List<String> validationErrors = new ArrayList<>();

    public ValidationResult(T toValidate) {
      this.toValidate = toValidate;
    }

    public ValidationResult<T> validationStep(Function<T, Boolean> validIf, String errorMessage) {
      if (!validIf.apply(toValidate)) {
        this.validationErrors.add(errorMessage);
      }
      return this;
    }

    public List<String> getValidationErrors() {
      return validationErrors;
    }

    public boolean isValid() {
      return this.validationErrors.isEmpty();
    }
  }
}
