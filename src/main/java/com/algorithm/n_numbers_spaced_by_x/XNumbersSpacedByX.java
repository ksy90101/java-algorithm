package com.algorithm.n_numbers_spaced_by_x;

import java.util.Arrays;

public class XNumbersSpacedByX {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
        System.out.println(Arrays.toString(solution(4, 3)));
        System.out.println(Arrays.toString(solution(-4, 2)));
    }

    public static long[] solution(final long x, final int n) {
        final long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x + x * i;
        }

        return answer;
    }
}
