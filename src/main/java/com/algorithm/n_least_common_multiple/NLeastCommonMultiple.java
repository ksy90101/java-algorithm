package com.algorithm.n_least_common_multiple;

public class NLeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 6, 8, 14}));
        System.out.println(solution(new int[] {1, 2, 3}));
    }

    public static int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 0; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }

        return lcm;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        int number1 = Math.max(a, b);
        int number2 = Math.min(a, b);

        while (number2 > 0) {
            int temp = number1 % number2;
            number1 = number2;
            number2 = temp;
        }

        return number1;
    }
}
