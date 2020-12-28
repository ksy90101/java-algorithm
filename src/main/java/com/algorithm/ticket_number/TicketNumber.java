package com.algorithm.ticket_number;

public class TicketNumber {
    private static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
    }

    public static void dfs(int node, int[] numbers, int target) {
        if (node == numbers.length) {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            if (sum == target) {
                answer++;
            }
        } else {
            numbers[node] *= 1;
            dfs(node + 1, numbers, target);

            numbers[node] *= -1;
            dfs(node + 1, numbers, target);
        }
    }

    public static int solution(int[] numbers, int target) {
        dfs(0, numbers, target);

        return answer;
    }
}

