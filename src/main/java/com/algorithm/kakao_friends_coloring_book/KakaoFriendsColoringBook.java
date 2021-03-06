package com.algorithm.kakao_friends_coloring_book;

import java.util.Arrays;
import java.util.Stack;

public class KakaoFriendsColoringBook {
    private static boolean[][] visited;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 4,
                new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
        System.out.println(Arrays.toString(solution(13, 16,
                new int[][] {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                        {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}})));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];

        return bfs(m, n, picture);
    }

    private static int[] bfs(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        Stack<Integer> sx = new Stack<>();
        Stack<Integer> sy = new Stack<>();

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                int count = 0;
                if (picture[row][column] != 0 && !visited[row][column]) {
                    answer[0]++;
                    count++;

                    add(sx, sy, row, column);
                }

                while (!sx.isEmpty()) {
                    int x = sx.pop();
                    int y = sy.pop();

                    if (x > 0 && picture[x - 1][y] == picture[row][column] && !visited[x - 1][y]) {
                        add(sx, sy, x - 1, y);
                        count++;
                    }
                    if (x < m - 1 && picture[x + 1][y] == picture[row][column] && !visited[x + 1][y]) {
                        add(sx, sy, x + 1, y);
                        count++;
                    }
                    if (y > 0 && picture[x][y - 1] == picture[row][column] && !visited[x][y - 1]) {
                        add(sx, sy, x, y - 1);
                        count++;
                    }
                    if (y < n - 1 && picture[x][y + 1] == picture[row][column] && !visited[x][y + 1]) {
                        add(sx, sy, x, y + 1);
                        count++;
                    }
                }
                answer[1] = Math.max(count, answer[1]);
            }
        }

        return answer;
    }

    private static void add(Stack<Integer> sx, Stack<Integer> sy, int x, int y) {
        sx.push(x);
        sy.push(y);
        visited[x][y] = true;
    }
}
