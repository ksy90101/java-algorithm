package com.algorithm.mockexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
	public int[] solution(int[] answers) {
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		List<Integer> students = Arrays.asList(0, 0, 0);

		// 완전탐색
		for (int i = 0; i < answers.length; i++) {
			int answer = answers[i];

			if (answer == student1[(i % 5)]) {
				students.set(0, students.get(0) + 1);
			}
			if (answer == student2[(i % 8)]) {
				students.set(1, students.get(1) + 1);
			}
			if (answer == student3[(i % 10)]) {
				students.set(2, students.get(2) + 1);
			}
		}

		int max = Math.max(students.get(0), Math.max(students.get(1), students.get(2))); // 최대값 구하기

		List<Integer> resultStudents = new ArrayList<>();
		for (int i = 0; i < students.size(); i++){ // 최대값과 같은 학생을 넣기
			if(students.get(i).equals(max)){
				resultStudents.add(i + 1);
			}
		}

		int[] result = new int[resultStudents.size()]; // List -> Array
		for (int i = 0; i < resultStudents.size(); i++) {
			result[i] = resultStudents.get(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] answer1 = {1, 2, 3, 4, 5};
		int[] answer2 = {1, 3, 2, 4, 2};
		MockExam mockExam = new MockExam();

		System.out.println(Arrays.toString(mockExam.solution(answer1)));
		System.out.println(Arrays.toString(mockExam.solution(answer2)));
	}
}
