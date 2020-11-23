package com.algorithm.function_development;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {

    public static final int COMPLETED_PROGRESS = 100;

    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[] {99, 1, 99, 1}, new int[] {1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[] {96, 99, 98, 97}, new int[] {1, 1, 1, 1})));
    }

    public static int[] solution(final int[] progresses, final int[] speeds) {
        final Queue<Integer> queue = new LinkedList<>();
        final List<Integer> answer = new ArrayList<>();

        for (int index = 0; index < progresses.length; index++) {
            int progressDate = (COMPLETED_PROGRESS - progresses[index]) / speeds[index];
            if ((COMPLETED_PROGRESS - progresses[index]) % speeds[index] != 0) {
                progressDate++;
            }
            queue.offer(progressDate);
        }

        int count = 1;
        int progressDate = queue.poll();

        while (!queue.isEmpty()) {
            if (progressDate >= queue.peek()) {
                count++;
                queue.poll();
                if (queue.isEmpty()) {
                    answer.add(count);
                }
                continue;
            }
            answer.add(count);
            count = 1;
            progressDate = queue.poll();
            if (queue.isEmpty()) {
                answer.add(count);
            }
        }

        return answer.stream()
                .mapToInt(n -> n)
                .toArray();
    }
}
