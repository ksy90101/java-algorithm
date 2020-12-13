package com.algorithm.representation_of_number;

public class RepresentationOfNumber {
    public static void main(final String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(final int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum > n) {
                    break;
                } else if (sum == n) {
                    count++;
                }
            }
        }

        return count;
    }
}
