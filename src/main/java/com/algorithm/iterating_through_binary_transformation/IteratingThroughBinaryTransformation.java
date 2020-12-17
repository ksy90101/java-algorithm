package com.algorithm.iterating_through_binary_transformation;

import java.util.Arrays;

public class IteratingThroughBinaryTransformation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }

    public static int[] solution(String s) {
        int zeroCount = 0;
        int transformationCount = 0;
        String binary = s;

        while (!"1".equals(binary)) {
            String binaryWithZero = binary.replaceAll("0", "");
            zeroCount += binary.length() - binaryWithZero.length();
            int transformationSize = binaryWithZero.length();
            binary = Integer.toBinaryString(transformationSize);
            transformationCount++;
        }

        return new int[] {transformationCount, zeroCount};
    }
}
