package com.algorithm;

import java.util.Arrays;
import java.util.List;

public class Solution10 {
    public static void main(final String[] args) {
        System.out.println(
                compareTriplets(
                        Arrays.asList(Arrays.asList(11, 2, 4), Arrays.asList(4, 5, 6), Arrays.asList(10, 8, -12))));
    }

    static int compareTriplets(final List<List<Integer>> arr) {
        int leftToRightDiagonalSum = 0;
        int rightToLeftDiagonalSum = 0;
        for (int index = 0; index < arr.size(); index++) {
            leftToRightDiagonalSum += arr.get(index).get(index);
            rightToLeftDiagonalSum += arr.get(index).get(arr.size() - index - 1);
        }

        return Math.max(leftToRightDiagonalSum, rightToLeftDiagonalSum) - Math.min(leftToRightDiagonalSum,
                rightToLeftDiagonalSum);
    }
}
