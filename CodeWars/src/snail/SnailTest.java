package snail;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class SnailTest {

  @Test
  public void SnailTest1() {
    int[][] array
        = {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};
    int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
    test(array, r);
  }

  @Test
  public void SnailTest4by4() {
    int[][] array
        = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};
    int[] r = {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};
    test(array, r);
  }

  @Test
  public void SnailTest5by5() {
    int[][] array =
        {{4, 6, 9, 0, 4},
            {9, 9, 9, 0, 3},
            {0, 1, 3, 9, 6},
            {6, 7, 4, 7, 2},
            {7, 1, 3, 4, 2}};
    int[] expected = {4, 6, 9, 0, 4, 3, 6, 2, 2, 4, 3, 1, 7, 6, 0, 9, 9, 9, 0, 9, 7, 4, 7, 1, 3};
    test(array, expected);
  }

  public String int2dToString(int[][] a) {
    return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
  }

  public void test(int[][] array, int[] result) {
    String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
    System.out.println(text);
    int[] calculated = Snail.snail(array);
    Assert.assertArrayEquals("but was: " + Arrays.toString(calculated), result, calculated);
  }


}
