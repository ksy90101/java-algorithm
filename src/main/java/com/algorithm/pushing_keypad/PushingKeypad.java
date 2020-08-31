package com.algorithm.pushing_keypad;

import java.util.Arrays;
import java.util.List;

enum Hand {
    LIFT(Arrays.asList(1, 4, 7)),
    RIGHT(Arrays.asList(3, 6, 9));

    private final List<Integer> numbers;

    Hand(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

public class PushingKeypad {

    private static final int[][] LOCATION = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1},
            {2, 2}, {3, 0}, {3, 2}};

    public static void main(final String[] args) {
        final int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        final String hand1 = "right";
        final int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        final String hand2 = "left";
        final int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        final String hand3 = "right";

        System.out.println(solution(numbers1, hand1));
        System.out.println(solution(numbers2, hand2));
        System.out.println(solution(numbers3, hand3));
    }

    public static String solution(final int[] numbers, final String hand) {
        final StringBuilder answer = new StringBuilder();
        int right = 10;
        int left = 11;

        for (final int number : numbers) {
            if (Hand.LIFT.getNumbers().contains(number)) {
                answer.append("L");
                left = number;
                continue;
            } else if (Hand.RIGHT.getNumbers().contains(number)) {
                answer.append("R");
                right = number;
                continue;
            }

            final int[] currentRight = LOCATION[right];
            final int[] currentLeft = LOCATION[left];
            final int[] next = LOCATION[number];

            final int diffRight = Math.abs(currentRight[0] - next[0]) + Math.abs(currentRight[1] - next[1]);
            final int diffLeft = Math.abs(currentLeft[0] - next[0]) + Math.abs(currentLeft[1] - next[1]);

            if (diffLeft == diffRight) {
                if ("left".equals(hand)) {
                    answer.append("L");
                    left = number;
                    continue;
                }
                answer.append("R");
                right = number;
                continue;
            }
            if (diffLeft > diffRight) {
                answer.append("R");
                right = number;
                continue;
            }
            answer.append("L");
            left = number;
        }

        return answer.toString();
    }
}
