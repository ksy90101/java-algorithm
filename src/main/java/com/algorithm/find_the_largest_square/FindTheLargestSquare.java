package com.algorithm.find_the_largest_square;

public class FindTheLargestSquare {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                map[row + 1][col + 1] = board[row][col];
            }
        }

        for (int row = 1; row < map.length; row++) {
            for (int col = 1; col < map[0].length; col++) {
                if (map[row][col] != 0) {
                    map[row][col] = Math.min(Math.min(map[row - 1][col], map[row][col - 1]), map[row - 1][col - 1]) + 1;
                }
                answer = Math.max(answer, map[row][col]);
            }
        }

        return answer * answer;
    }

}
