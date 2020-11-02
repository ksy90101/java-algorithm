# [\[프로그래머스\] 행렬의 덧셈](https://programmers.co.kr/learn/courses/30/lessons/12950?language=javascript)

## 문제 설명
행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

### 제한 조건
행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.

### 입출력 예
arr1 | arr2 | return
:---: | :---: | :---:
[[1,2],[2,3]] | [[3,4],[5,6]] | [[4,6],[7,9]]
[[1],[2]] | [[3],[4]] | [[4],[6]]

## 정답코드

```java
import java.util.Arrays;

public class MatrixAddition {
    public static void main(final String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][] {{1, 2}, {2, 3}}, new int[][] {{3, 4}, {5, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][] {{1}, {2}}, new int[][] {{3}, {4}})));
    }

    public static int[][] solution(final int[][] arr1, final int[][] arr2) {
        final int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            final int[] temp = new int[arr1[i].length];
            for (int j = 0; j < arr1[i].length; j++) {
                temp[j] = arr1[i][j] + arr2[i][j];
            }
            answer[i] = temp;
        }
        return answer;
    }
}

```