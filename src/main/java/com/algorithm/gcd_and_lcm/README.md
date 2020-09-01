# [\[프로그래머스\] 최대공약수와 최대공배수](https://programmers.co.kr/learn/courses/30/lessons/12940)

## 참고 지식

### [유클리드 호제법](https://namu.wiki/w/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C%20%ED%98%B8%EC%A0%9C%EB%B2%95)
- 예를 들어 3과 12의 최대 공약수를 구한다고 했을 때 3이 0보다 클때까지 반복한다.
1. a = 3, b = 12 -> a = 12 % 3 = 0 / b = 3
- 따라서 최대 공약수(GCD)은 b의 값인 3이 된다.

- 두번째 예로 a = 2, b = 5의 최대 공약수를 구한다고 했을 때 2가 0보다 클때까지 반복한다.
1. a = 2, b = 5 -> a = 5 % 2 = 1 / b = 2
2. a = 1, b = 2 -> a = 2 % 1 = 0 / b = 1
- 따라서 최대 공약수(GCD)의 값은 1이 된다.

- 주의사항은 작은 값을 a로 두고 큰 값을 b로 둬야한다는 점이다.

### 최대 공약수(GCD)를 이용해 최대 공배수(LCM)를 구하기.
- 공식

> LCM = (a * b) / GCD(a, b)

### [BigInteger.gcd()](https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html#gcd-java.math.BigInteger-) / 
- 자바에서는 최대 공약수를 구할 수 있는 메서드를 제공한다.
- 그러나 코딩 테스트에서 가끔 이 메서드를 사용하지 않고 직접 로직을 구현해야할 경우가 있다. 따라서 둘다 알아두면 좋다.

## 문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

### 제한 사항
- 두 수는 1이상 1000000이하의 자연수입니다.

### 입출력 예
n | m | return
:---: | :---: | :---:
3 | 12 | [3, 12]
2 | 5 | [1, 10]

### 입출력 예 설명
#### 입출력 예 #1
위의 설명과 같습니다.

#### 입출력 예 #2
자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.

## 정답 코드

```java
import java.util.Arrays;

public class GcdAndLcm {
    public static void main(final String[] args) {
        final int n1 = 3;
        final int m1 = 12;
        final int n2 = 2;
        final int m2 = 5;

        System.out.println(Arrays.toString(solution(n1, m1)));
        System.out.println(Arrays.toString(solution(n2, m2)));
    }

    public static int[] solution(final int n, final int m) {
        final int gcm = getLcm(n, m);
        final int lcm = (n * m) / gcm;

        return new int[] {gcm, lcm};
    }

    private static int getLcm(int n, int m) {
        while (n > 0) {
            final int temp = n;
            n = m % n;
            m = temp;
            System.out.println(n);
            System.out.println(m);
        }
        return m;
    }
}

```
