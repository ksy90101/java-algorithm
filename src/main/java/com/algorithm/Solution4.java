package com.algorithm;

public class Solution4 {
    public static void main(final String[] args) {
        System.out.println(solution(new int[] {2, 4, 1, 6, 5, 9, 7}));
        System.out.println(solution(new int[] {4, 3, 2, 6, 1}));
        System.out.println(solution(new int[] {2, 1, 6, 4, 3, 7, 8}));
        System.out.println(solution(new int[] {1, 2, 3, 4}));
        System.out.println(solution(new int[] {10, 2, 5, 6, 3, 11}));
    }

    public static int solution(final int[] A) {
        int answer = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j >= i; j--) {
                if (A[j] < A[i]) {
                    answer++;
                    i = j;
                    break;
                } else if (i == j) {
                    answer++;
                    return answer;
                }
            }
        }

        return answer;
    }
}
