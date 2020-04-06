package solutions.java.leetcode.Leetcode30DayChallenge;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19 Output: true
 * <p>
 * // '^' -> represents square here
 * <p>
 * Explanation: 1^2 + 9^2 = 82
 * <p>
 * 8^2 + 2^2 = 68
 * <p>
 * 6^2 + 8^2 = 100
 * <p>
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Day2_HappyNumber {

    public static void main(String[] args) {
        int[] numbers = { 19, 20, 1 };

        for (int n : numbers)
            System.out.println(Solution.isHappy(n));
    }

    private static class Solution {
        private static boolean isHappy(int n) {

            var checkIfLoop = new HashSet<Integer>();
            while (n != 1) {
                var current = n;
                var sum = 0;
                while (current != 0) {
                    var s = current % 10;
                    sum += s * s;
                    current /= 10;
                }

                if (checkIfLoop.contains(sum)) {
                    return false;
                } else {
                    checkIfLoop.add(sum);
                }
                n = sum;
            }

            return true;
        }
    }
}