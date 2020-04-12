package solutions.java.leetcode.Leetcode30DayChallenge;

import java.util.PriorityQueue;

public class Day12_LastStoneWeight {

    public static void main(String[] args) {
        int[][] stonesList = { { 2, 7, 4, 1, 8, 1 }, { 2, 2 }, {} };

        for (int[] stones : stonesList) {

            System.out.println(Solution.lastStoneWeight(stones));
            System.out.println("-----------------");
        }
    }

    private static class Solution {
        private static int lastStoneWeight(int[] stones) {
            if (stones.length == 1) {
                return stones[0];
            }
            var maxPQ = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));

            for (int stone : stones) {
                maxPQ.offer(stone);
            }

            while (maxPQ.size() > 1) {
                int a = maxPQ.poll();
                int b = maxPQ.poll();
                if (a > b) {
                    maxPQ.offer(a - b);
                }
            }

            return maxPQ.isEmpty() ? 0 : maxPQ.poll();
        }
    }
}