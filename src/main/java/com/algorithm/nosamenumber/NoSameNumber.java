package com.algorithm.nosamenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoSameNumber {
	public int[] solution(int[] arr) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				continue;
			}
			numbers.add(arr[i]);
		}
		numbers.add(arr[arr.length - 1]);

		int[] answer = new int[numbers.size()];
		for (int i = 0; i < numbers.size(); i++) {
			answer[i] = numbers.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		NoSameNumber noSameNumber = new NoSameNumber();
		int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
		int[] arr2 = {4, 4, 4, 3, 3};

		System.out.println(Arrays.toString(noSameNumber.solution(arr1)));
		System.out.println(Arrays.toString(noSameNumber.solution(arr2)));
	}
}
