# [\[프로그래머스\] 소수 찾기](https://programmers.co.kr/learn/courses/30/lessons/42839)

## 문제 설명

한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

### 제한사항

- numbers는 길이 1 이상 7 이하인 문자열입니다.
- numbers는 0~9까지 숫자만으로 이루어져 있습니다.
- 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

### 입출력 예

numbers | return
:---: | :---:
17 | 3
011 | 2

### 입출력 예 설명

- 예제 #1
    - [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

- 예제 #2
    - [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
    - 11과 011은 같은 숫자로 취급합니다.

[출처](http://2009.nwerc.eu/results/nwerc09.pdf)

## 정답

```java
import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumbers {
    private static boolean[] visited;
    private static Set<Integer> primeNumbers;
    private static char[] chars;

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];
        primeNumbers = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            chars = new char[i];
            perm(0, i, numbers.length(), numbers);
        }

        return primeNumbers.size();
    }

    private static void perm(int start, int r, int n, String numbers) {
        if (start == r) {
            if (chars[0] == '0') {
                return;
            }

            int number = Integer.parseInt(String.valueOf(chars));

            if (isPrimeNumber(number)) {
                primeNumbers.add(number);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            chars[start] = numbers.charAt(i);
            perm(start + 1, r, n, numbers);
            visited[i] = false;
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        int end = (int)Math.sqrt(number);
        for (int i = 2; i <= end; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

```
