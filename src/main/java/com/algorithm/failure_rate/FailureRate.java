package com.algorithm.failure_rate;

import java.util.Arrays;
import java.util.Collections;

public class FailureRate {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
        System.out.println(Arrays.toString(solution(8, new int[] {1, 2, 3, 4, 5, 6, 7})));
    }

    public static int[] solution(final int N, final int[] stages) {
        final int[] answer = new int[N];
        final Double[] failures = new Double[N];
        for (int i = 1; i < N + 1; i++) {
            int failureCount = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] < i) {
                    stages[j] = 0;
                }
                if (i == stages[j]) {
                    failureCount++;
                }
            }
            if (Double.isNaN(failureCount / (double)Arrays.stream(stages).filter(n -> n != 0).count())) {
                failures[i - 1] = 0d;
                continue;
            }
            failures[i - 1] = failureCount / (double)Arrays.stream(stages).filter(n -> n != 0).count();
        }

        final Double[] sorted = Arrays.copyOf(failures, failures.length);
        Arrays.sort(sorted, Collections.reverseOrder());

        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < failures.length; j++) {
                if (sorted[i].equals(failures[j])) {
                    answer[i] = j + 1;
                    failures[j] = -1d;
                    break;
                }
            }
        }

        return answer;
    }
}
