package com.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets {
    private static final Map<String, String> bracket = new HashMap<>();

    static {
        bracket.put("(", ")");
        bracket.put("[", "]");
        bracket.put("{", "}");
    }

    public static boolean isValid(final String brackets) {
        final Stack<String> stack = new Stack<>();

        final String[] splitedBrackets = brackets.split("");

        for (final String splitedBracket : splitedBrackets) {
            if (bracket.containsKey(splitedBracket)) {
                stack.add(splitedBracket);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                if (!bracket.get(stack.pop()).equals(splitedBracket)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(final String[] args) {
        System.out.println(ValidBrackets.isValid("[{()}]"));
        System.out.println(ValidBrackets.isValid("(]"));
        System.out.println(ValidBrackets.isValid("([)]"));
    }
}
