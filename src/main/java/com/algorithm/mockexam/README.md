# [\[프로그래머스\] 모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840)

## 문제 설명

수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한 조건
- 시험은 최대 10,000 문제로 구성되어있습니다.
- 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
- 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

### 입출력 예
| answers | return |
| :---: | :---: | 
| [1,2,3,4,5] | [1] | 
| [1,3,2,4,2] | [1,2,3] |

### 입출력 예 설명

#### 입출력 예 #1

- 수포자 1은 모든 문제를 맞혔습니다.
- 수포자 2는 모든 문제를 틀렸습니다.
- 수포자 3은 모든 문제를 틀렸습니다.
- 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

#### 입출력 예 #2

- 모든 사람이 2문제씩을 맞췄습니다.

## 정답

```java
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

    // Test Case
	public static void main(String[] args) {
		int[] answer1 = {1, 2, 3, 4, 5};
		int[] answer2 = {1, 3, 2, 4, 2};
		MockExam mockExam = new MockExam();

		System.out.println(Arrays.toString(mockExam.solution(answer1)));
		System.out.println(Arrays.toString(mockExam.solution(answer2)));
	}
}
```