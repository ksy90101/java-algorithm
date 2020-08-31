# [\[프로그래머스\] 짝수와 홀수](https://programmers.co.kr/learn/courses/30/lessons/12937)

## 문제 설명

정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.

### 제한 조건
- num은 int 범위의 정수입니다.
- 0은 짝수입니다.

### 입출력 예

num | return
:---: | :---:
3| Odd
4 | Even

## 정답코드
```java
public class EvenAndOdd {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 4;
        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    public static String solution(int num) {
        if (num % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }
}
```
