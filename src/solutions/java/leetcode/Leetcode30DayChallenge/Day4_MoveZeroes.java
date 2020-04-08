package solutions.java.leetcode.Leetcode30DayChallenge;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * <p>
 * Output: [1,3,12,0,0]
 */
public class Day4_MoveZeroes {

    static int[][] n = { { 0, 1, 0, 3, 12 } };

    public static void main(String[] args) {

        for (var nums : n) {
            Solution.moveZeroes(nums);
        }

    }

    private static class Solution {
        private static void moveZeroes(int[] nums) {

            int i = 0;
            for (int n : nums) {
                if (n != 0) {
                    nums[i++] = n;
                }
            }

            for (int j = i; j < nums.length; j++) {
                nums[j] = 0;
            }

            System.out.println(Arrays.toString(nums));
        }

    }
}