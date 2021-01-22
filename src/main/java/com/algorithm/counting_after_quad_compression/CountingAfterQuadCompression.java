package com.algorithm.counting_after_quad_compression;

import java.util.Arrays;

public class CountingAfterQuadCompression {
    private static int zero;
    private static int one;

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
        System.out.println(Arrays.toString(solution(
                new int[][] {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));
    }

    public static int[] solution(int[][] arr) {
        zero = 0;
        one = 0;
        dfs(arr.length, 0, 0, arr);
        return new int[] {zero, one};
    }

    private static void dfs(int n, int x, int y, int[][] arr) {
        if (n == 1) {
            if (arr[x][y] == 1) {
                one++;
            } else {
                zero++;
            }
            return;
        }
        if (isSame(n, x, y, arr)) {
            return;
        }

        dfs(n / 2, x, y, arr);
        dfs(n / 2, x + n / 2, y, arr);
        dfs(n / 2, x, y + n / 2, arr);
        dfs(n / 2, x + n / 2, y + n / 2, arr);
    }

    public static boolean isSame(int n, int x, int y, int[][] arr) {
        int first = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != arr[i][j]) {
                    return false;
                }
            }
        }

        if (first == 0) {
            zero += 1;
        } else {
            one += 1;
        }

        return true;
    }
}
