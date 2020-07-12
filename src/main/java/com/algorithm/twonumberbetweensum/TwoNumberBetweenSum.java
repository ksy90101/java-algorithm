package com.algorithm.twonumberbetweensum;

public class TwoNumberBetweenSum {
	public long solution(int a, int b) {
		long answer = 0;
		for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
			answer += i;
		}
		return answer;
	}

	public static void main(String[] args) {
		TwoNumberBetweenSum twoNumberBetweenSum = new TwoNumberBetweenSum();
		int a1 = 3;
		int b1 = 5;
		int a2 = 3;
		int b2 = 3;
		int a3 = 5;
		int b3 = 3;

		System.out.println(twoNumberBetweenSum.solution(a1, b1));
		System.out.println(twoNumberBetweenSum.solution(a2, b2));
		System.out.println(twoNumberBetweenSum.solution(a3, b3));
	}
}
