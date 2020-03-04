package solutions.java.leetcode;

public class Palindrome_Number {
    public static void main(String[] args) {
        int x = -121;

        System.out.println(Solution.isPalindrome(x));
    }

    /**
     * ********************
     * Solution
     * ********************
     */
    private static class Solution {
        static boolean isPalindrome(int x) {

            int y = (x < 0) ? x * -1 : x;

            int reverse = 0;
            while (y != 0) {
                reverse = y % 10 + reverse * 10;
                y /= 10;
            }

            return reverse == x;
        }
    }
}


