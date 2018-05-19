package Fracts;

/**
 * Created by doji on 19.05.18.
 *
 * Code Wars kata: http://www.codewars.com/kata/54d7660d2daf68c619000d95/train/java
 */
public class Fracts {

  // your code
  public static String convertFrac(long[][] lst) {
    if (lst == null || lst.length < 1) {
      return "";
    }

    long groepCommonMultiple = leastCommonMultiple(lst);
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < lst.length; i++) {
      result.append("(");
      result.append(lst[i][0] * (groepCommonMultiple / lst[i][1]));
      result.append(",");
      result.append(groepCommonMultiple);
      result.append(")");
    }

    return result.toString();
  }

  private static long leastCommonMultiple(long[][] lst) {
    long groepCommonMultiple = leastCommonMultiple(lst[0][1], lst[1][1]);
    for (int i = 2; i < lst.length; i++) {
      groepCommonMultiple = leastCommonMultiple(groepCommonMultiple, lst[i][1]);
    }
    return groepCommonMultiple;
  }

  private static long leastCommonMultiple(long a, long b) {
    return Math.abs(a * b) / greatestCommonDivider(a, b);
  }

  private static long greatestCommonDivider(long a, long b) {
    return b == 0 ? a : greatestCommonDivider(b, a % b);
  }

}
