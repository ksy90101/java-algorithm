package com.algorithm.kthnumber;

import java.util.Arrays;

public class KthNumber {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
			for (int i = 0; i < commands.length; i++) {
				int[] selectedArray = Arrays.copyOfRange(array, commands[i][0] -1 , commands[i][1]);
				Arrays.sort(selectedArray);
				answer[i] = selectedArray[commands[i][2] - 1];
			}
		return answer;
	}

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		KthNumber kthNumber = new KthNumber();
		System.out.println(Arrays.toString(kthNumber.solution(array, commands)));
	}
}
