package com.algorithm.more_spicy;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(final String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[] {1}, 7));
        System.out.println(solution(new int[] {1, 2}, 7));
    }

    public static int solution(final int[] scoville, final int K) {
        int answer = 0;
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (final int scovilleValue : scoville) {
            queue.add(scovilleValue);
        }

        while (K > queue.peek()) {
            if (queue.size() == 1) {
                return -1;
            }
            final int minScoville = queue.poll();
            final int twoMinScoville = queue.poll();

            queue.add(minScoville + twoMinScoville * 2);

            answer++;
        }

        return answer;
    }
}
