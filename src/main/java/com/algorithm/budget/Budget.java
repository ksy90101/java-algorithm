package com.algorithm.budget;

import java.util.Arrays;

public class Budget {
    public static void main(final String[] args) {
        System.out.println(solution(new int[] {1, 3, 2, 5, 4}, 9));
        System.out.println(solution(new int[] {2, 2, 3, 3}, 10));
    }

    public static int solution(final int[] d, final int budget) {
        int answer = 0;
        int maxSupport = 0;

        Arrays.sort(d);

        for (final int departmentBudget : d) {
            maxSupport += departmentBudget;
            if (maxSupport > budget) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
