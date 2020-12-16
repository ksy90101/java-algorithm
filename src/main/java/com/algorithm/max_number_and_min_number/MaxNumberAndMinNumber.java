package com.algorithm.max_number_and_min_number;

import java.util.Arrays;

public class MaxNumberAndMinNumber {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        return answer.append(numbers[0])
                .append(" ")
                .append(numbers[numbers.length - 1])
                .toString();
    }
}
