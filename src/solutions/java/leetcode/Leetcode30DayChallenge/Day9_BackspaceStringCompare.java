package solutions.java.leetcode.Leetcode30DayChallenge;

import java.util.Arrays;
import java.util.Stack;

public class Day9_BackspaceStringCompare {

    public static void main(String[] args) {

        String[][] ST = { { "ab#c", "ad#c" }, { "ab##", "c#d#" }, { "a##c", "#a#c" }, { "a#c", "b" }, { "", "" },
                { " ", " " }, { "a", "d" }, { "#", "#" }, { " a", "a" }, { "y#fo##f", "y#f#o##f" } };

        for (var ar : ST) {
            System.out.println();
            System.out.println(Arrays.toString(ar) + " : " + Solution.backspaceCompare(ar[0], ar[1]));
            System.out.println("____________________");
        }
    }

    private static class Solution {

        private static boolean backspaceCompare(String S, String T) {

            String check1 = checkCharacters(S);
            String check2 = checkCharacters(T);

            return check1.equals(check2);
        }

        private static String checkCharacters(String s) {

            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {

                if (c == '#' && !stack.isEmpty()) {
                    stack.pop();
                } else if (c != '#') {
                    stack.push(c);
                }
            }

            var stringBuilder = new StringBuilder();
            stack.forEach(e -> stringBuilder.append(e));

            return stringBuilder.toString();
        }
    }

}