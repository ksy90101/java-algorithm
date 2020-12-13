package com.algorithm;

public class Solution3 {

    private static final char FIVE = '5';

    public static void main(final String[] args) {
        System.out.println(solution(268));
        System.out.println(solution(670));
        System.out.println(solution(0));
        System.out.println(solution(-999));
    }

    public static int solution(final int N) {
        final String number = String.valueOf(N);
        final StringBuilder stringBuilder = new StringBuilder(number);
        final char[] digits = number.toCharArray();

        if (N >= 0) {
            for (int i = 0; i < digits.length; i++) {
                if (FIVE >= digits[i]) {
                    stringBuilder.insert(i, FIVE);
                    return Integer.parseInt(stringBuilder.toString());
                }
            }
            stringBuilder.append(FIVE);
            return Integer.parseInt(stringBuilder.toString());
        }

        for (int i = 1; i < digits.length; i++) {
            if (FIVE <= digits[i]) {
                stringBuilder.insert(i, FIVE);
                return Integer.parseInt(stringBuilder.toString());
            }
        }

        stringBuilder.append(FIVE);
        return Integer.parseInt(stringBuilder.toString());
    }
}
