package bracechecker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doji on 19.05.18.
 */
public class BraceChecker {

  public boolean isValid(String braces) {
    if(braces == null) {
      return false;
    }

    List<Character> stack = new ArrayList<>();
    for(int i = 0; i < braces.length(); i++) {
      char currentCharacter = braces.charAt(i);
      if(isOpenCharacter(currentCharacter)) {
        stack.add(currentCharacter);
      } else {
        if(stack.isEmpty()) {
          return false;
        }
        Character lastOnStack = stack.get(stack.size() - 1);
        if (!isValidAgainstLastStackItem(currentCharacter, lastOnStack)) {
          return false;
        }
        stack.remove(stack.size() - 1);
      }
    }
    return stack.isEmpty();
  }

  private boolean isValidAgainstLastStackItem(char currentCharacter, Character lastOnStack) {
    if(currentCharacter == ')' && lastOnStack == '(') {
      return true;
    } else if(currentCharacter == ']' && lastOnStack == '[') {
      return true;
    } else if(currentCharacter == '}' && lastOnStack == '{') {
      return true;
    } else {
      return false;
    }
  }

  private boolean isOpenCharacter(char currentCharacter) {
    return currentCharacter == '(' || currentCharacter == '[' || currentCharacter == '{';
  }
}
