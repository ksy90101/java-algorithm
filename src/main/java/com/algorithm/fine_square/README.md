# [\[프로그래머스\] 멀쩡한 사각형](https://programmers.co.kr/learn/courses/30/lessons/62048)

## 풀이방법
- 이러한 문제에서 규칙을 찾아봐야 합니다.
- 사진을 보면 실제 규칙이 있는 것 처럼 보이기도 합니다.
- 실제로 끝나는 지점을 생각해 본다면 [2,3] / [4,6] / [6,9] / [8,12] 이러한 규칙을 가지고 있습니다.
- 이때 W는 2씩 증가를 하고 H는 3씩 증가하는것을 볼 수 있습니다.
- 아울러 8, 12의 최소 공약수를 구하면 맨 처음 규칙이 언제부터 시작되는 것을 확인할 수 있습니다.
- 또한 실제 직사각형 종이에서 실제 사용하지 않는 정사각형을 구해보면 (w * h)-(w + h - 1)가 되는걸 볼 수 있습니다.
- 이러한 규칙을 모두 종합해서 풀면 될꺼라고 생각합니다.

## 문제 설명
가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

### 제한사항
W, H : 1억 이하의 자연수

### 입출력 예
W | H | result
:---: | :---: | :---:
8 | 12 | 80

###입출력 예 설명
#### 입출력 예 #1
가로가 8, 세로가 12인 직사각형을 대각선 방향으로 자르면 총 16개 정사각형을 사용할 수 없게 됩니다. 원래 직사각형에서는 96개의 정사각형을 만들 수 있었으므로, 96 - 16 = 80 을 반환합니다.

![572957326.92.png](https://grepp-programmers.s3.amazonaws.com/files/production/ee895b2cd9/567420db-20f4-4064-afc3-af54c4a46016.png)

## 정답

```java
import java.math.BigInteger;

public class FineSquare {
    public static void main(final String[] args) {
        System.out.println(solution(8, 16));
    }

    public static long solution(final long w, final long h) {
        final long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        return (w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);
    }
}

```