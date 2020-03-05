package solutions.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2] // i.e All occurrences are included
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        Map<int[], int[]> questionMap = new LinkedHashMap<>();
        questionMap.put(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        questionMap.put(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        questionMap.put(new int[0], new int[0]);
        questionMap.put(new int[]{3, 2, 4, 3, 2, 4}, new int[]{3, 2, 4, 2, 3});

        questionMap.forEach((q1, q2) -> System.out.println(Arrays.toString(Solution.intersect(q1, q2))));
    }

    private static class Solution {
        public static int[] intersect(int[] nums1, int[] nums2) {

            Map<Integer, Integer> map;

            // To decrease the number of loops in the getSolution method
            if (nums1.length > nums2.length) {
                map = getMap(nums1);
                return getSolution(map, nums2);
            } else {
                map = getMap(nums2);
                return getSolution(map, nums1);
            }
        }

        private static int[] getSolution(Map<Integer, Integer> map, int[] nums) {

            int[] output = new int[nums.length];
            int i = 0;
            for (int n : nums) {
                if (map.containsKey(n) && map.get(n) > 0) {
                    output[i++] = n;
                    map.put(n, map.get(n) - 1);
                }
            }

            return Arrays.copyOf(output, i);
        }

        private static Map<Integer, Integer> getMap(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            return map;
        }
    }
}
