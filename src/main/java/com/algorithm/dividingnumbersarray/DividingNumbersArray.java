package com.algorithm.dividingnumbersarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DividingNumbersArray {
	public int[] solution(int[] arr, int divisor) {
		List<Integer> dividingNumbers = new ArrayList<>();
		for (int number : arr) {
			if (number % divisor == 0) {
				dividingNumbers.add(number);
			}
		}

		if (dividingNumbers.size() == 0) {
			return new int[] {-1};
		}

		int[] answer = new int[dividingNumbers.size()];
		for (int i = 0; i < dividingNumbers.size(); i++) {
			answer[i] = dividingNumbers.get(i);
		}

		Arrays.sort(answer);

		return answer;
	}

	public static void main(String[] args) {
		DividingNumbersArray dividingNumbersArray = new DividingNumbersArray();
		int[] arr1 = {5, 9, 7, 10};
		int divisor1 = 5;
		int[] arr2 = {2, 36, 1, 3};
		int divisor2 = 1;
		int[] arr3 = {3, 2, 6};
		int divisor3 = 10;
		System.out.println(Arrays.toString(dividingNumbersArray.solution(arr1, divisor1)));
		System.out.println(Arrays.toString(dividingNumbersArray.solution(arr2, divisor2)));
		System.out.println(Arrays.toString(dividingNumbersArray.solution(arr3, divisor3)));
	}
}
