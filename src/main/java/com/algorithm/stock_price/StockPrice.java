package com.algorithm.stock_price;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
    }

    public static int[] solution(final int[] prices) {
        final Stack<Integer> stack = new Stack<>();
        final int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                final Integer index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            final Integer index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}
