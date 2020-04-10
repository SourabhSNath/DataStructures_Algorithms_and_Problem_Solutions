package solutions.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array
 * are smaller than it. That is, for each nums[i] you have to count the number
 * of valid j's such that j != i and nums[j] < nums[i].
 * 
 * Return the answer in an array.
 * 
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class SmallerThantheCurrentNumber {

    public static void main(String[] args) {
        int[][] narr = { { 8, 1, 2, 2, 3 }, { 7, 7, 7, 7 } };
        for (int[] nums : narr) {
            System.out.println(Arrays.toString(Solution.smallerNumbersThanCurrent(nums)));
        }
    }

    private static class Solution {
        private static int[] smallerNumbersThanCurrent(int[] nums) {

            int[] copy = nums.clone();
            Arrays.sort(copy);

            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                map.putIfAbsent(copy[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                copy[i] = map.get(nums[i]);
            }

            return copy;
        }
    }
}