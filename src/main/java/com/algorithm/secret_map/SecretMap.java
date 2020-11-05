package com.algorithm.secret_map;

import java.util.Arrays;

public class SecretMap {

    private static final String ONE_SYMBOL = "#";
    private static final String TWO_SYMBOL = " ";

    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28})));
        System.out.println(
                Arrays.toString(solution(6, new int[] {46, 33, 33, 22, 31, 50}, new int[] {27, 56, 19, 14, 14, 10})));
    }

    public static String[] solution(final int n, final int[] arr1, final int[] arr2) {
        final String[] answer = new String[n];
        final String binaryFormat = "%0" + n + "d";
        for (int i = 0; i < arr1.length; i++) {
            final StringBuilder binary = new StringBuilder();
            final String binary1 = String.format(binaryFormat, Long.parseLong(Integer.toBinaryString(arr1[i])));
            final String binary2 = String.format(binaryFormat, Long.parseLong(Integer.toBinaryString(arr2[i])));
            final String[] splitedBinary1 = binary1.split("");
            final String[] splitedBinary2 = binary2.split("");

            for (int j = 0; j < splitedBinary1.length; j++) {
                final int num1 = Integer.parseInt(splitedBinary1[j]);
                final int num2 = Integer.parseInt(splitedBinary2[j]);

                if ((num1 | num2) == 1) {
                    binary.append(ONE_SYMBOL);
                    continue;
                }
                binary.append(TWO_SYMBOL);
            }

            answer[i] = binary.toString();
        }

        return answer;
    }
}
