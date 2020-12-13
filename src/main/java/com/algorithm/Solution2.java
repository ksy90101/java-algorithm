package com.algorithm;

public class Solution2 {
    public static void main(final String[] args) {
        System.out.println(solution(new int[] {1, 0, 1, 0, 1, 1}));
        System.out.println(solution(new int[] {1, 1, 0, 1, 1}));
        System.out.println(solution(new int[] {0, 1, 0}));
        System.out.println(solution(new int[] {0, 1, 1, 0}));
    }

    public static int solution(final int[] A) {
        int zeroAndOne = 0;
        int oneAndZero = 0;
        final int[] zeroAndOneOrder = {0, 1};
        final int[] oneAndZeroOrder = {1, 0};
        for (int i = 0; i < A.length; i++) {
            final int order = i % 2;
            if (zeroAndOneOrder[order] != A[i]) {
                zeroAndOne++;
            }
            if (oneAndZeroOrder[order] != A[i]) {
                oneAndZero++;
            }
        }
        return Math.min(oneAndZero, zeroAndOne);
    }

}
