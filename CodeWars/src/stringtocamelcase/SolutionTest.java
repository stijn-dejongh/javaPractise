package stringtocamelcase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by Stijn Dejongh on 19.05.18.
 * <p>
 * Code for CodeWars kata: http://www.codewars.com/kata/517abf86da9663f1d2000003/train/java
 */
public class SolutionTest {

  @Test
  public void testSomeUnderscoreLowerStart() {
    String input = "the_Stealth_Warrior";
    System.out.println("input: " + input);
    assertEquals("theStealthWarrior", Solution.toCamelCase(input));
  }

  @Test
  public void testSomeDashLowerStart() {
    String input = "the-Stealth-Warrior";
    System.out.println("input: " + input);
    assertEquals("theStealthWarrior", Solution.toCamelCase(input));
  }

  @Test
  public void testEmptyString() {
    String input = "";
    System.out.println("input: " + input);
    assertEquals("", Solution.toCamelCase(input));
  }

  @Test
  public void testSomeDashUpperStart() {
    String input = "The-Stealth-Warrior";
    System.out.println("input: " + input);
    assertEquals("TheStealthWarrior", Solution.toCamelCase(input));
  }
}