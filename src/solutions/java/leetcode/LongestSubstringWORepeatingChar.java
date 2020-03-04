package solutions.java.leetcode;

import java.util.Arrays;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

public class LongestSubstringWORepeatingChar {

    public static void main(String[] args) {

        String input = "abcabcbb";

        System.out.println(Solution.lengthOfLongestSubstring(input));
    }

    private static class Solution {
        private static int lengthOfLongestSubstring(String input) {

            int[] subSequenceLengthHolder = new int[input.toCharArray().length];
            Arrays.fill(subSequenceLengthHolder, 1);

            for (int i = 0; i < input.toCharArray().length; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.println(j);
                    break;
//                    if (input.toCharArray()[i] == input.toCharArray()[j]) {
//                        subSequenceLengthHolder[i] = Math.max(subSequenceLengthHolder[i], subSequenceLengthHolder[j] + 1);
//                    }
                }
            }

            return subSequenceLengthHolder[0];
        }
    }
}
