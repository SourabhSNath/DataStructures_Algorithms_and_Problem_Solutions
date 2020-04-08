package solutions.java.leetcode.Leetcode30DayChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2,3] Output: 2 Explanation: 1 and 2 are counted cause 2 and 3
 * are in arr. Example 2:
 * 
 * Input: arr = [1,1,3,3,5,5,7,7] Output: 0 Explanation: No numbers are counted,
 * cause there's no 2, 4, 6, or 8 in arr. Example 3:
 * 
 * Input: arr = [1,3,2,3,5,0] Output: 3 Explanation: 0, 1 and 2 are counted
 * cause 1, 2 and 3 are in arr. Example 4:
 * 
 * Input: arr = [1,1,2,2] Output: 2 Explanation: Two 1s are counted cause 2 is
 * in arr.
 */
public class Day7_CountingElements {

    public static void main(String[] args) {

        int[][] allElements = { { 1, 2, 3 }, { 1, 1, 3, 3, 5, 5, 7, 7 }, { 1, 3, 2, 3, 5, 0 }, { 1, 1, 2, 2 }, { 1 } };

        for (var arr : allElements) {
            System.out.println(Arrays.toString(arr) + " = " + Solution.countElements(arr));
        }
    }

    private static class Solution {
        private static int countElements(int[] arr) {

            if (arr.length == 1)
                return 0;

            Set<Integer> set = new HashSet<>();
            int count = 0;
            for (int i : arr) {
                set.add(i);
            }

            for (int x : arr) {
                if (set.contains(x + 1)) {
                    count++;
                }
            }

            return count;
        }
    }
}