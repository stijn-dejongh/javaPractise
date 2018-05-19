package stringtocamelcase;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Stijn Dejongh on 19.05.18.
 * <p>
 * Code for CodeWars kata: http://www.codewars.com/kata/517abf86da9663f1d2000003/train/java
 */

class Solution {

    static String toCamelCase(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] split = s.split("-|_");
        return split[0] + Arrays.stream(split).skip(1).map(part -> convertPart(part)).collect(Collectors.joining()).replaceAll("-|_", "");
    }

    private static String convertPart(String part) {
        return (part.substring(0, 1).toUpperCase() + part.substring(1));
    }
}
