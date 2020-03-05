package solutions.java.leetcode;

import java.util.Arrays;

/**
 * Plus one to an array representing an integer
 * array = [1,2,3] which represents an integer number 123
 * add one to this number
 * so output [1,2,4]
 * <p>
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public static void main(String[] args) {
        int[][] plus = {{1, 2, 3}, {4, 3, 2, 1}, {0}, {9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6},
                {1, 1, 9},
                {9}};
        for (int[] digits : plus) {
            System.out.println(Arrays.toString(Solution.plusOne(digits)));
        }
    }

    private static class Solution {
        public static int[] plusOne(int[] digits) {

            var length = digits.length;
            for (int i = length - 1; i >= 0; i--) {
                // If the last digit is less than 9, increment it and return the array
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                // If it is 9, then make it 0
                // In the next loop, the next position of i (which is the previous pos because i--)
                // will be incremented and then returned; i.e 19 -> 20 and then return
                digits[i] = 0;
            }

            // If the loop exits because everything is 9, create a new array which starts with 1
            // which is it's +1.
            // 99 -> 100 (in array form [1,0,0])
            int[] newArray = new int[length + 1];
            newArray[0] = 1;

            return newArray;
        }
    }
}