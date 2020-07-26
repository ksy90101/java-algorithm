# [\[프로그래머스\] 수박수박수박수박수박수?](https://programmers.co.kr/learn/courses/30/lessons/12922https://programmers.co.kr/learn/courses/30/lessons/12922)

## 문제 설명
길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

### 제한 조건
- n은 길이 10,000이하인 자연수입니다.1

### 입출력 예
n | return
:---: | :---:
3 | 수박수
4 | 수박수박

## 정답코드

```java
package com.algorithm.suback_suback;

public class SuBack {
    public static void main(String[] args) {
        SuBack suBack = new SuBack();
        int n1 = 3;
        int n2 = 4;

        System.out.println(suBack.solution(n1));
        System.out.println(suBack.solution(n2));
    }

    public String solution(int n) {
        int number = n / 2;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < number; i++) {
            answer.append("수박");
        }
        if (n % 2 != 0) {
            return answer.append("수").toString();
        }
        return answer.toString();
    }
}
```
