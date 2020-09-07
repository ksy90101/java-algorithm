package com.algorithm.finding_average;

import java.util.Arrays;

public class FindingAverage {
    public static void main(final String[] args) {
        final int[] arr1 = {1, 2, 3, 4};
        final int[] arr2 = {5, 5};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    public static double solution(final int[] arr) {
        return Arrays.stream(arr)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값입니다."));
    }
}
