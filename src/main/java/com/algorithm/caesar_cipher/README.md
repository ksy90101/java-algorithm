# [\[프로그래머스\] 시저 암호](https://programmers.co.kr/learn/courses/30/lessons/12926)

## 문제 설명
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

### 제한 조건
- 공백은 아무리 밀어도 공백입니다.
- s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
- s의 길이는 8000이하입니다.
- n은 1 이상, 25이하인 자연수입니다.

### 입출력 예
s | n | result
:---: | :---: | :---:
AB | 1 | BC
z | 1 | a
a B z | 4 | e F d

## 정답 코드
```java
package com.algorithm.caesar_cipher;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        String s1 = "AB";
        int n1 = 1;
        String s2 = "z";
        int n2 = 1;
        String s3 = "a B z";
        int n3 = 4;

        System.out.println(caesarCipher.solution(s1, n1));
        System.out.println(caesarCipher.solution(s2, n2));
        System.out.println(caesarCipher.solution(s3, n3));
    }

    public String solution(String s, int n) {
        List<Character> toLowerChar = new ArrayList<>();
        List<Character> toUpperChar = new ArrayList<>();
        char[] split = s.toCharArray();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            toLowerChar.add((char)('a' + i));
            toUpperChar.add((char)('A' + i));
        }

        for (char value : split) {
            if (toUpperChar.contains(value)) {
                int index = (toUpperChar.indexOf(value) + n) % 26;
                answer.append(toUpperChar.get(index));
                continue;
            } else if (toLowerChar.contains(value)) {
                int index = (toLowerChar.indexOf(value) + n) % 26;
                answer.append(toLowerChar.get(index));
                continue;
            }
            answer.append(value);
        }
        return answer.toString();
    }
}
```