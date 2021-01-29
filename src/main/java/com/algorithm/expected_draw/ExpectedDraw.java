package com.algorithm.expected_draw;

public class ExpectedDraw {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;
        int left = Math.min(a, b);
        int right = Math.max(a, b);

        while (left != right) {
            left = (left + 1) / 2;
            right = (right + 1) / 2;
            answer++;
        }

        return answer;
    }
}
