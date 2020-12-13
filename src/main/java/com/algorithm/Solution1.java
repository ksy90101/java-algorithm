package com.algorithm;

public class Solution1 {
    public static void main(final String[] args) {
        System.out.println(solution(60));
        System.out.println(solution(27));
        System.out.println(solution(1234));
    }

    public static int solution(final int N) {
        final int numberOfUnits = N % 10;
        final int salt = 10 - numberOfUnits;
        return N + salt;
    }
}
