# [\[프로그래머스\] 문자열 다루기 기본](https://programmers.co.kr/learn/courses/30/lessons/12918)

## 문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

### 제한 사항
- s는 길이 1 이상, 길이 8 이하인 문자열입니다.

### 입출력 예
s | return
:---: | :---:
a234 | false
1234 | true

## 정답 코드

```java
public class BasicString {
    public boolean solution(String s) {
        try {
            Integer.parseInt(s);
            return s.length() == 4 || s.length() == 6;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "a234";
        String s2 = "1234";
        BasicString basicString = new BasicString();
        System.out.println(basicString.solution(s1));
        System.out.println(basicString.solution(s2));
    }
}
```
