package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;

/**
 * Created by doji on 26.05.18.
 *
 * Solution for Code Wars Kata:
 * http://www.codewars.com/kata/586423aa39c5abfcec0001e6/train/java
 *
 * Using Texas Hold'em hand ranking:
 * https://www.cardplayer.com/rules-of-poker/hand-rankings
 */
public class PokerHand implements Comparable<PokerHand> {

  private List<String> hand;
  private HashMap<Integer, Function<List<String>, Boolean>> handRanks = populateHandRankMap();
  private static List<String> faceValues = Arrays
      .asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K",
          "A");

  public PokerHand(String hand) {
    this.hand = new ArrayList(Arrays.asList(hand.split(" ")));
  }

  double calulateRankValue() {
    for (Entry<Integer, Function<List<String>, Boolean>> rankChecker : handRanks.entrySet()) {
      if (rankChecker.getValue().apply(hand)) {
        return rankChecker.getKey();
      }
    }
    return Double.MAX_VALUE;
  }

  private static HashMap<Integer, Function<List<String>, Boolean>> populateHandRankMap() {
    HashMap<Integer, Function<List<String>, Boolean>> handRanks = new HashMap<>();
    handRanks.put(1, PokerHand::isRoyalFlush);
    handRanks.put(2, PokerHand::isStraightFlush);
    handRanks.put(3, PokerHand::isFourOfAkind);

    //TODO: fill out further
    return handRanks;
  }

  static boolean isRoyalFlush(List<String> hand) {
    return getSortedHandCardIndices(hand).get(0) == 8
        && isStraight(hand);
  }

  static boolean isStraightFlush(List<String> hand) {
    return isStraight(hand)
        && isSuited(hand);
  }

  static boolean isFourOfAkind(List<String> hand) {
    return hasSameFaceValue(hand, 4);
  }


  private static boolean hasSameFaceValue(List<String> hand, int occurenceTime) {
    HashSet<Integer> hash = new HashSet<>();
    hash.addAll(getSortedHandCardIndices(hand));
    return hash.size() == 6 - occurenceTime;
  }

  private static char getHighestCardInEvent() {
    //TODO
    return 'X';
  }

  private static char getHighCard() {
    //TODO
    return 'X';
  }

  private static boolean isSuited(List<String> hand) {
    char suitToCheck = hand.get(0).charAt(1);
    return hand.stream().map(card -> card.charAt(1)).allMatch(suit -> suit == suitToCheck);
  }

  private static boolean isStraight(List<String> hand) {
    List<Integer> indices = getSortedHandCardIndices(hand);
    for (int i = 1; i < indices.size(); i++) {
      if (indices.get(i) == 12 && indices.get(0) == 0) {
        // If the last hand card is an Ace, and the first one is a 2, they are still consecutive
        continue;
      }
      if (indices.get(i) - indices.get(i - 1) != 1) {
        return false;
      }
    }
    return true;
  }

  private static List<Integer> getSortedHandCardIndices(List<String> hand) {
    List<Integer> indices = new ArrayList<>();
    for (String card : hand) {
      indices.add(Integer.valueOf(faceValues.indexOf("" + card.charAt(0))));
    }
    Collections.sort(indices);
    return indices;
  }

  @Override
  public int compareTo(PokerHand other) {
    return -Double.compare(this.calulateRankValue(), other.calulateRankValue());
  }
}
