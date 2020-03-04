package solutions.java.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Sort the characters in the string according to the number of times they were repeated
 * Example: O/p for tree -> eert
 * O/p for wolololo -> oooolllw
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {

        var words = new ArrayList<String>();
        words.add("tree");
        words.add("cccaaa");
        words.add("Aabb");
        words.add("wolololo");
        words.add("");

        for (var word : words) {
            System.out.println(Solution.sortByFreq(word));
        }
    }

    private static final class Solution {

        private static String sortByFreq(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            map = map.entrySet().stream()
                    .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            StringBuilder stringBuilder = new StringBuilder();

            map.forEach((k, v) -> {
                stringBuilder.append(String.valueOf(k).repeat(v));
            });


//            Method 2
//            --------
//            Iterator<Map.Entry<Character, Integer>> mapIterator = map.entrySet().iterator();
//            while (mapIterator.hasNext()) {
//                var next = mapIterator.next();
//                    for (int i = 0; i < next.getValue(); i++) {
//                        stringBuilder.append(next.getKey());
//                }
//            }

            return stringBuilder.toString();
        }
    }

}
