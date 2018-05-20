package sumofdivided;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by doji on 20.05.18.
 */
public class SumOfDivided {

  public static String sumOfDivided(int[] l) {
    StringBuilder result = new StringBuilder();
    Arrays.sort(l);
    for (int prime : generatePrimes(l[l.length - 1])) {
      result.append(stringifySumIfDivisible(l, prime));
    }
    return result.toString();
  }

  private static String stringifySumIfDivisible(int[] l, int prime) {
    StringBuilder result = new StringBuilder("");
    int[] divisibleInputNumbers = Arrays.stream(l)
        .filter(inputNumber -> inputNumber % prime == 0).toArray();
    if (divisibleInputNumbers.length > 0) {
      result.append("(")
          .append(prime)
          .append(" ")
          .append(Arrays.stream(divisibleInputNumbers).sum())
          .append(")");
    }
    return result.toString();
  }

  /* Erotosthenes Sieve
  https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Pseudocode
   */
  private static int[] generatePrimes(int upperBound) {
    BitSet bitSet = new BitSet(upperBound);
    bitSet.set(0, false);
    bitSet.set(1, false);
    bitSet.set(2, upperBound, true);

    for (int i = 2; i * i < upperBound; i++) {
      if (bitSet.get(i)) {
        int j = i;
        int x = 2;
        while (j < upperBound) {
          j = i * x;
          bitSet.set(j, false);
          x++;
        }
      }
    }
    return bitSet.stream().toArray();
  }
}
