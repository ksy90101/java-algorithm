package com.algorithm.matrix_addition;

import java.util.Arrays;

public class MatrixAddition {
    public static void main(final String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][] {{1, 2}, {2, 3}}, new int[][] {{3, 4}, {5, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][] {{1}, {2}}, new int[][] {{3}, {4}})));
    }

    public static int[][] solution(final int[][] arr1, final int[][] arr2) {
        final int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            final int[] temp = new int[arr1[i].length];
            for (int j = 0; j < arr1[i].length; j++) {
                temp[j] = arr1[i][j] + arr2[i][j];
            }
            answer[i] = temp;
        }
        return answer;
    }
}
