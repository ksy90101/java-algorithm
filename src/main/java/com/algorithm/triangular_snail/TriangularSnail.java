package com.algorithm.triangular_snail;

import java.util.Arrays;

public class TriangularSnail {
    private static final int TOTAL_DIRECTION = 3;
    private static final int[] dx = new int[] {1, 0, -1};
    private static final int[] dy = new int[] {0, 1, -1};

    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }

    public static int[] solution(final int n) {
        final int totalSize = n * (n + 1) / 2;
        final int[] answer = new int[totalSize];
        final int[][] matrix = new int[n][n];
        int x = 0;
        int y = 0;

        int direction = 0;
        for (int i = 1; i <= totalSize; i++) {
            matrix[x][y] = i;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || matrix[nx][ny] != 0) {
                direction = (direction + 1) % TOTAL_DIRECTION;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index] = matrix[i][j];
                index++;
            }
        }

        return answer;
    }
}
