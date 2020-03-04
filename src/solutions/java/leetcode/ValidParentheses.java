package solutions.java.leetcode;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {

        List<String> braceList = Arrays.asList(
                "{}", // true
                "()", //true
                "[{]}", //false
                "[{()}]", //true
                "]", //false
                "[", //false
                "((", //false
                "))", //false
                "" //true
        );

        braceList.forEach(s -> System.out.println(s + ": " + Solution.isValid(s)));
    }

    /**
     * ****************
     * SOLUTION
     * ****************
     */
    private static class Solution {
        private static boolean isValid(String s) {

            if (s.length() == 1) return false;

            Map<Character, Character> braceMap = new HashMap<>();
            braceMap.put(')', '(');
            braceMap.put('}', '{');
            braceMap.put(']', '[');

            Stack<Character> parenStack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == ')' || c == '}' || c == ']') {
                    if (parenStack.isEmpty() || parenStack.pop() != braceMap.get(c)) {
                        return false;
                    }
                } else
                    parenStack.push(c);

            }

            return parenStack.isEmpty();
        }
    }

}

