package solutions.java.leetcode.Leetcode30DayChallenge;

import static java.lang.Math.max;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],  
 * <p>
 * Output: 6
 * <p>
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class Day3_MaximumSubarray {

    public static void main(String[] args) {

        int[][] nArrays = { { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, { 1 }, { -2, 1 }, { -1 } };

        for (int[] nums : nArrays) {
            System.out.println(Solution.maxSubArray(nums));
        }

        // System.out.println(Solution.maxSubArray(new int[] { -2, 1 }));

    }

    /**
     * Using Kadane's Algorithm
     */

    private static class Solution {
        private static int maxSubArray(int[] nums) {

            int max = Integer.MIN_VALUE, sum = 0;
            for (int i : nums) {
                sum += i;
                max = max(sum, max);
                // Get rid of the sum if the sum is less than 0, this can't be the answer.
                // But since max is before this, the better negative number
                // becomes the answer in case there are no positive answers.
                sum = max(sum, 0);
            }
            return max;
        }
    }
}