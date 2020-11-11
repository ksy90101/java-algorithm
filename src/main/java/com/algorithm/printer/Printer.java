package com.algorithm.printer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {

    public static void main(final String[] args) {
        System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(final int[] priorities, final int location) {
        int answer = 1;
        final Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (final int priority : priorities) {
            queue.add(priority);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}
