package com.algorithm.stock_price;

import java.util.Arrays;

public class StockPrice {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
    }

    public static int[] solution(final int[] prices) {

        final int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int second = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    second++;
                } else {
                    answer[i] = second + 1;
                    break;
                }
                if (j == prices.length - 1) {
                    answer[i] = second;
                }
            }
        }
        return answer;
    }
}
