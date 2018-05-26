package snail;

/**
 * Created by doji on 21.05.18.
 *
 * Code wars kata:
 * https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java
 *
 * not the cleanest code, sorry
 */
public class Snail {

  public static int[] snail(int[][] array) {
    int i = 0;
    int j = 0;
    int maxI = array.length - 1;
    int maxJ = array.length - 1;
    int minJ = 0;
    int minI = 0;
    int stepsNeeded = array.length * array[0].length;
    int stepsTaken = 0;
    int tourCount = 0;
    int[] snailedResult = new int[stepsNeeded];
    while (stepsTaken < stepsNeeded && i < array.length && i >= 0 && j < array.length && j >= 0) {
      snailedResult[stepsTaken] = array[i][j];
      if( stepsTaken - tourCount == (2 * maxI + 2* maxJ) - 1) {
        maxI --;
        maxJ--;
        minJ++;
        minI++;
        tourCount += (2 * maxI + 2* maxJ) - 1;
      }

      if (j == maxJ && i < maxI) {
        //going down
        i++;
      } else {
        if (i == minI && i < array.length / 2) {
          //going right
          j++;
        } else {
          if (j > minJ) {
            //going left
            j--;
          } else {
            if(i > minI) {
              //going up
              i--;
            } else {
              // we're at the end!
              j += (i < ((double) array.length / 2)) ? 1 : -1;
            }
          }
        }
      }

      stepsTaken++;
    }
    return snailedResult;
  }
}
