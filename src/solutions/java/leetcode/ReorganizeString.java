package solutions.java.leetcode;

import java.util.*;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent
 * to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * <p>
 * Input: S = "aaab"
 * Output: ""
 */
@SuppressWarnings("SpellCheckingInspection")
public class ReorganizeString {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("aab", "aaab", "", "woooollll");

        for (String s : stringList) {
            System.out.println("Output: " + Solution.reorganizeString(s));
        }

    }

    private static class Solution {
        public static String reorganizeString(String s) {

            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            StringBuilder stringBuilder = new StringBuilder();
            PriorityQueue<Character> maxHeapPriorityQueue = new PriorityQueue<>((a, b) -> map.get(b).compareTo(map.get(a)));
            maxHeapPriorityQueue.addAll(map.keySet());

            // Until priority queue has 1 character left
            while (maxHeapPriorityQueue.size() > 1) {
                // Greedily taking the max occuring first and second character
                var current = maxHeapPriorityQueue.remove();
                var next = maxHeapPriorityQueue.remove();

                stringBuilder.append(current).append(next);

                // Now reduce the number of occurence within the map for the current and next value
                map.put(current, map.get(current) - 1);
                map.put(next, map.get(next) - 1);

                // Adding them back into the maxHeapPriorityQueue as long as it's occurance isn't 0
                if (map.get(current) > 0) {
                    maxHeapPriorityQueue.add(current);
                }
                if (map.get(next) > 0) {
                    maxHeapPriorityQueue.add(next);
                }
            }

            // If there is a character left in the heap
            if (!maxHeapPriorityQueue.isEmpty()) {
                char lastCharacter = maxHeapPriorityQueue.remove();

                // If it still occurs more than once
                if (map.get(lastCharacter) > 1) {
                    // Return empty string since there is nothing to insert in between to seperate the left over characters
                    return "";
                } else {
                    stringBuilder.append(lastCharacter);
                }
            }

            return stringBuilder.toString();
        }
    }
}
