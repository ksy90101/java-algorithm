# [\[프로그래머스\] 가운데 글자 가져오기](https://programmers.co.kr/learn/courses/30/lessons/12903)

## 문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

### 재한사항
- s는 길이가 1 이상, 100이하인 스트링입니다.

### 입출력 예
| s | return |
| :---: | :---: |
| abcde	c |
| qwer | we |

## 코드

```java
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
```
