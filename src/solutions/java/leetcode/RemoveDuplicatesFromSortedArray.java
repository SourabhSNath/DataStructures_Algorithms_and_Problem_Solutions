package solutions.java.leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * -
 * Example 1:
 * -
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        /*
         * This final array was changed in the output because final only prevents the reference from being changed
         * i.e you cannot set nums = new int[3] or something else
         * but the items inside the array can be changed
         */
        final int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};


        var index = Solution.removeDuplicates(nums);

        for (int i = 0; i < index; i++) {
            System.out.println(nums[i]);
        }

    }

    private static class Solution {
        public static int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            var prev = nums[0];
            var index = 1;
            for (int n : nums) {
                if (n != prev) {
                    nums[index++] = n;
                    prev = n;
                }
            }

            System.out.println("Index: " + index);
            return index;
        }
    }
}
