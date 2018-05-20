package DigitalRoot;

/**
 * Created by doji on 20.05.18.
 *
 * Code for Code Wars kata:
 * https://www.codewars.com/kata/541c8630095125aba6000c00/train/java
 */
public class DRoot {

  public static int digital_root(int n) {
    int compressed = Integer.toString(n).chars().map(c -> c - '0').sum();
    return compressed > 9 ? compressed : digital_root(compressed);
  }
}
