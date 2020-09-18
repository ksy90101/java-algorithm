package com.algorithm.sum_matrix;

import java.util.Arrays;

public class SumMatrix {
    public static void main(final String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][] {{1, 2}, {2, 3}}, new int[][] {{3, 4}, {5, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][] {{1}, {2}}, new int[][] {{3}, {4}})));
    }

    public static int[][] solution(final int[][] arr1, final int[][] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        return arr1;
    }
}
