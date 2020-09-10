# [\[프로그래머스\] 핸드폰 번호 가리기](https://programmers.co.kr/learn/courses/30/lessons/12948)

## 문제 설명
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

### 제한 조건
- s는 길이 4 이상, 20이하인 문자열입니다.

### 입출력 예
phone_number | return
:---: | :---:
01033334444 | *******4444
027778888 | *****8888

## 정답코드

```java
public class HidePhoneNumber {
    public static void main(final String[] args) {
        final String phoneNumber1 = "0103334444";
        final String phoneNumber2 = "027778888";

        System.out.println(solution(phoneNumber1));
        System.out.println(solution(phoneNumber2));
    }

    public static String solution(final String phone_number) {
        final StringBuilder answer = new StringBuilder();
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer.append("*");
        }
        answer.append(phone_number.substring(phone_number.length() - 4));

        return answer.toString();
    }
}
```
