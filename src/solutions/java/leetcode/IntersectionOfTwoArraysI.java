package solutions.java.leetcode;

import java.util.*;

/**
 * Part 1
 * -------
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 */
public class IntersectionOfTwoArraysI {

    public static void main(String[] args) {
        // Map containing both arrays required for the questions
        Map<int[], int[]> questionMap = new LinkedHashMap<>();
        questionMap.put(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        questionMap.put(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        questionMap.put(new int[0], new int[0]);
        questionMap.put(new int[]{3, 2, 4, 3, 2, 4}, new int[]{3, 2, 4, 2, 3});

        questionMap.forEach((q1, q2) -> System.out.println(Arrays.toString(Solution.intersection(q1, q2))));
    }

    private static class Solution {
        public static int[] intersection(int[] nums1, int[] nums2) {

            Set<Integer> set = new HashSet<>();
            Set<Integer> set1 = new HashSet<>();

            for (int i : nums1) {
                set.add(i);
            }

            for (int i : nums2) {
                set1.add(i);
            }

            int[] output = new int[set.size()];
            int i = 0;
            for (int n : set) {
                if (set1.contains(n)) {
                    output[i++] = n;
                }
            }

            return Arrays.copyOf(output, i);
        }

    }
}
