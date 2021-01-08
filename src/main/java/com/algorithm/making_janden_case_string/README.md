# [\[프로그래머스\] JadenCase 문자열 만들기](https://programmers.co.kr/learn/courses/30/lessons/12951)

## 문제 설명

JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

### 제한 조건

- s는 길이 1 이상인 문자열입니다.
- s는 알파벳과 공백문자(" ")로 이루어져 있습니다.
- 첫 문자가 영문이 아닐때에는 이어지는 영문은 소문자로 씁니다. ( 첫번째 입출력 예 참고 )

### 입출력 예

s | return
:---: | :---:
3people unFollowed me | 3people Unfollowed Me
for the last week | For The Last Week

## 문제 해설

- 각 문자열의 각 문자를 검사할 수 있는 메서드(toJandenCase())를 만들었습니다.
- 일단, 영문자가 아니면 그 문자는 그대로 리턴을 하게 만들었으며, 첫 글자일 경우에만 대문자로, 나머지는 모두 소문자로 변경할 수 있도록 처리했습니다.
- 여기서 주의해야 할 점은 공백이 들어올수도 있다는 점입니다. (예를들면 for the last week   )
- 이거에 대한 처리해도 해줘야 하기 때문에 문자열이 비어있는지 확인하고 비어있다면 넘어가도록 해줬습니다.
  (테스트 케이스 8번이 실패할 경우 이 부분을 한번 확인해보세요.)

## 정답코드

```java
public class MakingJandenCaseString {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution("for the last week  "));
    }

    public static String solution(String s) {
        String[] splitedStrings = s.split(" ", -1);

        for (int i = 0; i < splitedStrings.length; i++) {
            if (splitedStrings[i].isEmpty()) {
                continue;
            }
            splitedStrings[i] = toJandenCase(splitedStrings[i]);
        }

        return String.join(" ", splitedStrings);
    }

    private static String toJandenCase(String str) {
        StringBuilder jandenCase = new StringBuilder();
        char[] charaters = str.toCharArray();

        for (int i = 0; i < charaters.length; i++) {
            if (!Character.isAlphabetic(charaters[i])) {
                jandenCase.append(charaters[i]);
                continue;
            } else if (i == 0) {
                jandenCase.append(Character.toUpperCase(charaters[i]));
                continue;
            }
            jandenCase.append(Character.toLowerCase(charaters[i]));
        }

        return jandenCase.toString();
    }
}

```
