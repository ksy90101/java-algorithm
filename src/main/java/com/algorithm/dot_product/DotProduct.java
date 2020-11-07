package com.algorithm.dot_product;

public class DotProduct {
    public static void main(final String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4}, new int[] {-3, -1, 0, 2}));
        System.out.println(solution(new int[] {-1, 0, 1}, new int[] {1, 0, -1}));
    }

    public static int solution(final int[] a, final int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }
}
