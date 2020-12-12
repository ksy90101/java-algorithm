package com.algorithm.largest_number;

import java.util.Arrays;

public class LargestNumber {
    public static void main(final String[] args) {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
        System.out.println(solution(new int[] {40, 403}));
    }

    public static String solution(final int[] numbers) {
        final String[] numberToString = new String[numbers.length];

        for (int index = 0; index < numbers.length; index++) {
            numberToString[index] = String.valueOf(numbers[index]);
        }

        Arrays.sort(numberToString, (a, b) -> (b + a).compareTo(a + b));

        if ("0".equals(numberToString[0])) {
            return "0";
        }

        return String.join("", numberToString);
    }
}
