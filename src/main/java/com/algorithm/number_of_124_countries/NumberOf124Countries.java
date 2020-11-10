package com.algorithm.number_of_124_countries;

public class NumberOf124Countries {
    public static void main(final String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
    }

    public static String solution(int n) {
        final int[] countryNumber = new int[] {4, 1, 2};
        final StringBuilder answer = new StringBuilder();
        while (n > 0) {
            answer.insert(0, countryNumber[(n % 3)]);
            if (n % 3 == 0) {
                n -= 1;
            }
            n = n / 3;
        }
        return answer.toString();
    }
}
