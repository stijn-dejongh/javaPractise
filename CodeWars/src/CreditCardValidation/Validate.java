package CreditCardValidation;

/**
 * Created by Stijn Dejongh on 19.05.18.
 * <p>
 * Code Wars Kata: https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2/train/java
 *
 * this is a very unelegant solution.
 * A cleaner and more consise way of doing this can be seen here:
 * https://www.codewars.com/kata/reviews/596cc24a665de321f40000e8/groups/59b5b3dd1d74fc4fd7001be5
 */
public class Validate {

  public static boolean validate(String n) {
    if (n.length() < 2) {
      return false;
    }

    int result = 0;
    boolean toDouble = false;
    for (int i = n.length() - 1; i >= 0; i--) {
      int value = n.charAt(i) - '0'; //Fancy way of converting a char to an int
      if (toDouble) {
        int doubled = value * 2;
        result += (doubled > 9 ? (doubled - 9) : doubled);
      } else {
        result += value;
      }
      toDouble = !toDouble;
    }

    return (result % 10) == 0;
  }
}
