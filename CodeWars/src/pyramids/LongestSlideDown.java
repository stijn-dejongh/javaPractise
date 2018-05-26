package pyramids;

import java.util.Arrays;

/**
 * Created by doji on 23.05.18.
 *
 * Solution for code wars kata:
 * http://www.codewars.com/kata/551f23362ff852e2ab000037/train/java
 */
public class LongestSlideDown {
  public static int longestSlideDown(int[][] pyramid) {
    int[][] pyramidCopy = Arrays.copyOf(pyramid, pyramid.length);
    for(int i = pyramidCopy.length - 2; i >= 0; i--) {
      for(int j = 0; j < pyramidCopy[i].length; j++) {
        int leftSum = pyramidCopy[i][j] + pyramidCopy[i + 1][j];
        int rightSum = pyramidCopy[i][j] + pyramidCopy[i + 1][j+1];
        pyramidCopy[i][j] = Math.max(leftSum, rightSum);
      }
    }

    return pyramidCopy[0][0];
  }
}
