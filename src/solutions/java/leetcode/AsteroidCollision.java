package solutions.java.leetcode;

import java.util.*;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 1, 2};

        System.out.println(Arrays.toString(Solution.asteroidCollision(arr)));
    }

    private static class Solution {
        private static int[] asteroidCollision(int[] asteroids) {

            var stack = new Stack<Integer>();
            var survivors = new ArrayList<Integer>();
            for (int a : asteroids) {
                if (a > 0)
                    stack.push(a);
                else {
                    if (!stack.isEmpty() && a * -1 != stack.pop())
                        survivors.add(Math.max(a * -1, stack.pop()));
                }
            }

            survivors.addAll(stack);
            int[] newArr = new int[survivors.size()];
            int i = 0;
            for (int a : survivors) {
                newArr[i++] = a;
            }

            return newArr;

        }
    }
}