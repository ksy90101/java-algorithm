package com.algorithm.harshad_number;

public class HarshadNumber {
    public static boolean solution(final int x) {
        int number = x;
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }

        return x % sum == 0;
    }

    public static void main(final String[] args) {
        final int x1 = 10;
        final int x2 = 12;
        final int x3 = 11;
        final int x4 = 13;

        System.out.println(solution(x1));
        System.out.println(solution(x2));
        System.out.println(solution(x3));
        System.out.println(solution(x4));
    }
}
