# [\[프로그래머스\] 평균 구하기](https://programmers.co.kr/learn/courses/30/lessons/12944)

## 문제 설명
정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

### 제한사항
- arr은 길이 1 이상, 100 이하인 배열입니다.
- arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.

### 입출력 예
arr | return
:---: | :---:
[1,2,3,4] | 2.5
[5,5] | 5

## 정답

```java
package com.algorithm.finding_average;

import java.util.Arrays;

public class FindingAverage {
    public static void main(final String[] args) {
        final int[] arr1 = {1, 2, 3, 4};
        final int[] arr2 = {5, 5};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    public static double solution(final int[] arr) {
        return Arrays.stream(arr)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값입니다."));
    }
}

```
