package com.algorithm.fibonacci_numbers;

public class FibonacciNumbers {
    public static void main(final String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }

    public static int solution(final int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            final int c = (a + b) % 1234567;
            a = b % 1234567;
            b = c % 1234567;
        }

        return a;
    }
}
