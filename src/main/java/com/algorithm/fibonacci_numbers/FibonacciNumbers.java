package com.algorithm.fibonacci_numbers;

public class FibonacciNumbers {
    private static int[] cache;

    public static void main(final String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }

    public static int solution(final int n) {
        cache = new int[n + 1];

        return fibo(n);
    }

    public static int fibo(final int n) {
        final double sqrt = Math.sqrt(5);

        return (int)(1 / sqrt * (Math.pow((1 + sqrt) / 2, n) - Math.pow((1 - sqrt) / 2, n)));
    }

}
