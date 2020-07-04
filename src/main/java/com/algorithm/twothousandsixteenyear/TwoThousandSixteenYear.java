package com.algorithm.twothousandsixteenyear;

import java.time.LocalDate;

public class TwoThousandSixteenYear {
	public String solution(int a, int b) {
		LocalDate localDate = LocalDate.of(2016, a, b);
		return localDate.getDayOfWeek().toString().substring(0, 3);
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		TwoThousandSixteenYear twoThousandSixteenYear = new TwoThousandSixteenYear();
		System.out.println(twoThousandSixteenYear.solution(a, b));
	}
}
