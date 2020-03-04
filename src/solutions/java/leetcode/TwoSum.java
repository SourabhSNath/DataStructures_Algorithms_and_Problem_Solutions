package solutions.java.leetcode;

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(Solution.twoSum(numbers, target)));
    }

    private static class Solution {

        /**
         * O(n^2) solution
         */
        static int[] twoSum(int[] numbers, int target) {

            int value = 0;
            for (int i = 0; i < numbers.length; i++) {


                value = target - numbers[i];

                System.out.println(value);
                for (int j = 0; j < numbers.length; j++) {
                    if (j != i && numbers[j] == value) {
                        return new int[]{i, j};
                    }
                }
            }

            return new int[]{0, 0};
        }
    }
}
