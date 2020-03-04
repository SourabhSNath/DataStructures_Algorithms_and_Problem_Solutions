package datastructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketMatching {

    public static void main(String[] args) {
        String brackets = "{([])}";

        System.out.println(isStackEmpty(brackets));


    }

    private static boolean isStackEmpty(String brackets) {

        Map<Character, Character> bracketPair = new HashMap<>();

        bracketPair.put(')', '(');
        bracketPair.put(']', '[');
        bracketPair.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : brackets.toCharArray()) {

            if (bracketPair.containsValue(c)) {
                stack.push(c);
            } else if (stack.pop() != bracketPair.get(c) || stack.isEmpty()) {
                return false;
            }

        }


        return !stack.isEmpty();
    }

}
