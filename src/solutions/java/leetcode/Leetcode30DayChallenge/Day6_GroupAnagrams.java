package solutions.java.leetcode.Leetcode30DayChallenge;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day6_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        System.out.println(Solution.groupAnagrams(strs));
    }

    private static class Solution {
        private static List<List<String>> groupAnagrams(String[] strs) {

            var returnList = new ArrayList<List<String>>();
            var map = new HashMap<String, List<String>>();

            for (String s : strs) {
                char[] sc = s.toCharArray();
                Arrays.sort(sc);
                String sorted = new String(sc);

                if (!map.containsKey(sorted)) {
                    map.put(sorted, new ArrayList<>());
                }

                map.get(sorted).add(s);
            }
            returnList.addAll(map.values());
            return returnList;
        }
    }

}