package solutions.java.leetcode;

import java.util.HashMap;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };

        System.out.println(Solution.findLHS(nums));
    }

    private static class Solution {
        private static int findLHS(int[] nums) {

            if (nums == null || nums.length == 0)
                return 0;

            int count = 0;

            var map = new HashMap<Integer, Integer>();

            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);

                if (map.containsKey(n + 1)) {
                    count = Math.max(count, map.get(n) + map.get(n + 1));
                } else if (map.containsKey(n - 1)) {
                    count = Math.max(count, map.get(n) + map.get(n - 1));
                }

            }

            return count;
        }
    }

}