package digpow;

import java.util.stream.IntStream;

/**
 * Created by doji on 19.05.18.
 *
 * Code Wars kata: https://www.codewars.com/kata/5552101f47fc5178b1000050/train/java
 */
public class DigPow {


  public static long digPow(int n, int p) {
    String digits = Integer.toString(n);
    double powSum = IntStream.range(0, digits.length())
        .map(i -> (int) Math.pow((double) (digits.charAt(i) - '0'), (double) p + i)).sum();
    return (powSum % n) == 0 ? (long) (powSum / n) : -1;
  }

  // Made this implementation first one because I was scared of rounding errors
  public static long firstDigPow(int n, int p) {
    String digits = Integer.toString(n);
    double powSum = 0;
    for (int i = 0; i < digits.length(); i++) {
      powSum += Math.pow((double) (digits.charAt(i) - '0'), (double) p + i);
    }
    return (powSum % n) == 0 ? (long) (powSum / n) : -1;
  }
}
