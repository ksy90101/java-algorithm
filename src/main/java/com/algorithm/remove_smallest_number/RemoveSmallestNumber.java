package com.algorithm.remove_smallest_number;

import java.util.Arrays;

public class RemoveSmallestNumber {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 1};
        int[] arr2 = {10};

        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        int smallestNumber = sortedArr[0];

        return afterRemoveNumber(arr, smallestNumber);
    }

    private static int[] afterRemoveNumber(int[] arr, int smallestNumber) {
        int[] answer = Arrays.stream(arr)
                .filter(number -> number != smallestNumber)
                .toArray();

        if (answer.length == 0) {
            return new int[] {-1};
        }
        return answer;
    }
}
