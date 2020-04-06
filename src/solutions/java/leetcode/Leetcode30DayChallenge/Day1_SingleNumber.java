package solutions.java.leetcode.Leetcode30DayChallenge;

/**
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1 Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 */

public class Day1_SingleNumber {
    public static void main(String[] args) {

        int[][] numsContainer = { { 2, 2, 1 }, { 4, 1, 2, 1, 2 } };
        for (var nums : numsContainer) {
            System.out.println(Solution.singleNumber(nums));
        }

    }

    /**
     * Using xor here Xor of a number with 0 is the number itself Xor of the number
     * with itself is 0 Here since the output is just repeated once, it survives,
     * because the the pairs will cancel itself out.
     * <p>
     * for : { 4, 1, 2, 1, 2 }
     * <p>
     * o/p : 4.
     * <p>
     * Internally : 4, 5, 7, 6, 4 <- 4 get's out in the end because 2 removes itself
     * from the xor in the end
     */

    private static class Solution {
        private static int singleNumber(int[] nums) {

            var x = 0;
            for (var n : nums) {
                x ^= n;
                System.out.print(x);
            }

            return x;
        }
    }
}