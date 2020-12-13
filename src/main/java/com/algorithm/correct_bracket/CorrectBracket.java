package com.algorithm.correct_bracket;

import java.util.Stack;

public class CorrectBracket {
    private final static char CLOSE_BRACKET = ')';

    public static void main(final String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    static boolean solution(final String s) {
        final char[] brackets = s.toCharArray();
        final Stack<Character> stack = new Stack<>();

        for (final char bracket : brackets) {
            if (CLOSE_BRACKET == bracket && stack.isEmpty()) {
                return false;
            } else if (CLOSE_BRACKET == bracket && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.push(bracket);
        }

        return stack.isEmpty();
    }
}
