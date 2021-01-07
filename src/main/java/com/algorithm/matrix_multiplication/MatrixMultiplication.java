package com.algorithm.matrix_multiplication;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(solution(new int[][] {{1, 4}, {3, 2}, {4, 1}}, new int[][] {{3, 3}, {3, 3}})));
        System.out.println(
                Arrays.deepToString(solution(new int[][] {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}},
                        new int[][] {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}})));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int row = 0; row < arr1.length; row++) {
            for (int column = 0; column < arr2[0].length; column++) {
                int sum = 0;
                for (int index = 0; index < arr2.length; index++) {
                    sum += arr1[row][index] * arr2[index][column];
                }
                answer[row][column] = sum;
            }
        }
        return answer;
    }
}
