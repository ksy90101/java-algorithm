package com.algorithm.getmiddlecharacter;

public class GetMiddleCharacter {
	public String solution(String s) {
		if (s.length() % 2 == 0) {
			return s.substring(s.length() / 2 - 1, s.length() / 2 +1);
		}
		return s.substring(s.length() / 2, s.length() / 2 + 1);
	}

	public static void main(String[] args) {
		GetMiddleCharacter getMiddleCharacter = new GetMiddleCharacter();
		String s1 = "abcde";
		String s2 = "qwer";

		System.out.println(getMiddleCharacter.solution(s1));
		System.out.println(getMiddleCharacter.solution(s2));
	}
}
