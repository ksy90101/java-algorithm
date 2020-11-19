package com.algorithm.function_development;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FunctionDevelopment {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
    }

    public static int[] solution(final int[] progresses, final int[] speeds) {
        final Stack<Integer> stack = new Stack<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));
        }

        final List<Integer> answer = new ArrayList<>();

        while (!stack.isEmpty()) {
            int count = 1;
            final int top = stack.pop();

            while (!stack.isEmpty() && stack.peek() <= top) {
                count++;
                stack.pop();
            }

            answer.add(count);
        }

        return answer.stream()
                .mapToInt(n -> n)
                .toArray();
    }
}
