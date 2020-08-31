package com.algorithm.even_and_odd;

public class EvenAndOdd {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 4;
        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    public static String solution(int num) {
        if (num % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }
}
