package com.algorithm.pick_two_and_add;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickTwoAndAdd {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[] {5, 0, 2, 7})));
    }

    public static int[] solution(final int[] numbers) {
        final Set<Integer> answer = new HashSet<>();
        for (int idx = 0; idx < numbers.length; idx++) {
            for (int i = idx + 1; i < numbers.length; i++) {
                answer.add(numbers[idx] + numbers[i]);
            }
        }
        return answer.stream()
                .mapToInt(n -> n)
                .sorted()
                .toArray();
    }
}
