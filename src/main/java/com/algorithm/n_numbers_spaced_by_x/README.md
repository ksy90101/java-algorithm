# [\[프로그래머스\] x만큼 간격이 있는 n개의 숫자](https://programmers.co.kr/learn/courses/30/lessons/12954)

## 특이점
- int와 long의 범위를 알아야 한다.
- int의 범위는 `-2,147,483,648~2,147,483,647`입니다.
- long의 범위는 `-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807`입니다.
- int + int는 int가 나오며 long + long이 long이 나온다.
- 여기서 나올수 있는 최대의 값을 생각해본다면 x가 10,000,000 n이 1,000인 경우이다.
- 그렇다면 최대값은 int의 범위를 넘는 10,000,000,000 값이 나오게 되기 때문에 인자를 long으로 설정하거나 타입 캐스팅을 해야 한다.

## 문제 설명
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

### 제한 조건
- x는 -10000000 이상, 10000000 이하인 정수입니다.
- n은 1000 이하인 자연수입니다.

## 입출력 예
x | n | answer
:---: | :---: | :---:
2 | 5 | [2,4,6,8,10]
4 | 3 | [4,8,12]
-4 | 2 | [-4, -8]

## 정답코드
```java
import java.util.Arrays;

public class XNumbersSpacedByX {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
        System.out.println(Arrays.toString(solution(4, 3)));
        System.out.println(Arrays.toString(solution(-4, 2)));
    }

    public static long[] solution(final long x, final int n) {
        final long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x + x * i;
        }

        return answer;
    }
}
```
