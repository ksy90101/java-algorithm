package com.algorithm.twonumberbetweensum;

public class TwoNumberBetweenSum {
    public static void main(final String[] args) {
        final int a1 = 3;
        final int b1 = 5;
        final int a2 = 3;
        final int b2 = 3;
        final int a3 = 5;
        final int b3 = 3;

        System.out.println(TwoNumberBetweenSum.solution(a1, b1));
        System.out.println(TwoNumberBetweenSum.solution(a2, b2));
        System.out.println(TwoNumberBetweenSum.solution(a3, b3));
    }

    public static long solution(final int a, final int b) {
        long answer = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }
        return answer;
    }
}
