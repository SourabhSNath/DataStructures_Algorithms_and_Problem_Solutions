package solutions.java.leetcode.Leetcode30DayChallenge;

import java.util.ArrayList;
import java.util.List;

public class Day5_BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {

        List<int[]> priceList = new ArrayList<>();
        priceList.add(new int[] { 7, 1, 5, 3, 6, 4 });
        priceList.add(new int[] { 1, 2, 3, 4, 5 });
        priceList.add(new int[] { 7, 6, 4, 3, 1 });

        for (var prices : priceList) {
            System.out.println(Solution.maxProfit(prices));
        }

    }

    private static class Solution {
        public static int maxProfit(int[] prices) {

            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    profit += prices[i + 1] - prices[i];
                }

            }

            return profit;
        }
    }
}