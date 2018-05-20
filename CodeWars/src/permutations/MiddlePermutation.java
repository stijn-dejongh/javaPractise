package permutations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;

/**
 * Created by doji on 20.05.18.
 *
 * Code Wars kata: https://www.codewars.com/kata/58ad317d1541651a740000c5/train/java
 */
public class MiddlePermutation {

  public static String findMidPerm(String input) {
    Assert.assertTrue(2 <= input.length() && input.length() <= 26);
    List<String> elements = new ArrayList<>(Arrays.asList(input.split("")));
    Collections.sort(elements);
    BigDecimal indexOfPermutationToReturn = (factorial(input.length()))
        .divide(BigDecimal.valueOf(2));
    return getNthPermutation(elements, indexOfPermutationToReturn);
  }

  /**
   * Takes a list of sorted String elements and the returns the Nth permutation,
   * considering the alphabetically sorted set of possible permutations.
   *
   * @param indexOfPermutationToReturn must be greater or equal to 1
   * @param elements must be a non-empty collection
   */
  private static String getNthPermutation(List<String> elements,
      BigDecimal indexOfPermutationToReturn) {
    if (elements.size() == 1) {
      return elements.get(0);
    }
    Assert.assertTrue(indexOfPermutationToReturn.compareTo(BigDecimal.valueOf(0)) >= 0);
    Assert.assertFalse(elements == null);
    Assert.assertTrue(elements.size() > 0);

    BigDecimal amountOfBuckets = BigDecimal.valueOf(elements.size());
    BigDecimal bucketSize = factorial(elements.size()).divide(amountOfBuckets);
    int targetBucketIndex = (int) Math
        .ceil(indexOfPermutationToReturn.divide(bucketSize).doubleValue());
    BigDecimal remainingPermitationIndex =
        indexOfPermutationToReturn
            .subtract(bucketSize.multiply(BigDecimal.valueOf((long) targetBucketIndex - 1)));
    String targetBucketIdentifier = elements.get(targetBucketIndex - 1);
    elements.remove(targetBucketIdentifier);
    return targetBucketIdentifier + getNthPermutation(elements, remainingPermitationIndex);
  }


  private static BigDecimal factorial(int number) {
    BigDecimal result = BigDecimal.valueOf(1);

    for (int factor = 2; factor <= number; factor++) {
      result = BigDecimal.valueOf(factor).multiply(result);
    }

    return result;
  }
}
