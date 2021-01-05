package com.algorithm.matching_and_removing;

import java.util.ArrayDeque;
import java.util.Deque;

public class MatchingAndRemoving {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (!stack.isEmpty() && stack.peek() == aChar) {
                stack.pop();
                continue;
            }

            stack.push(aChar);
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}
