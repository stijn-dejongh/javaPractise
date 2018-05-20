package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Assert;

/**
 * Created by doji on 20.05.18.
 *
 * Code Wars kata: https://www.codewars.com/kata/58ad317d1541651a740000c5/train/java
 *
 * This initial naive solution has a terrible complexity.
 * For proof of this, refer to the testLongInput() in the test class.
 * If you were to run that test, using this implementation of findMidTerm, you can verify it has terrible performance
 */
class MiddlePermutationNaive {

  public static String findMidPerm(String input) {
    Assert.assertTrue(2 <= input.length() && input.length() <= 26);
    List<String> dictionary = generateDictionary(input.split(""));
    Collections.sort(dictionary);
    return dictionary.get(Math.round(dictionary.size() / 2) - 1);
  }

  static List<String> generateDictionary(String[] elements) {
    Set<String> dictionary = new HashSet<>();
    recursiveGenerateDictionary(elements, 0, dictionary);
    return new ArrayList<>(dictionary);
  }

  private static void recursiveGenerateDictionary(String[] elements, int start,
      Set<String> dictionary) {
    if (start < elements.length) {
      for (int j = start; j < elements.length; j++) {
        swap(elements, start, j);
        recursiveGenerateDictionary(elements, start + 1, dictionary);
        swap(elements, start, j);
      }
    } else {
      dictionary.add(Arrays.stream(elements).collect(Collectors.joining()));
    }
  }

  private static boolean swap(String[] original, int indexFirst, int indexSecond) {
    String temp = original[indexFirst];
    original[indexFirst] = original[indexSecond];
    original[indexSecond] = temp;
    return true;
  }


}
