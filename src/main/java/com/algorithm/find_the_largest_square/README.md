# [\[프로그래머스\] 가장 큰 정사각형 찾기](https://programmers.co.kr/learn/courses/30/lessons/12905)

## 문제 설명

1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해
주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

예를 들어

1 | 2 | 3 | 4
:---: | :---: | :---: | :---:
0 | 1 | 1 | 1
1 | 1 | 1 | 1
1 | 1 | 1 | 1
0 | 0 | 1 | 0

가 있다면 가장 큰 정사각형은

1 | 2 | 3 | 4
:---: | :---: | :---: | :---:
0 | 1 | 1 | 1
1 | 1 | 1 | 1
1 | 1 | 1 | 1
0 | 0 | 1 | 0

가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

### 제한사항

- 표(board)는 2차원 배열로 주어집니다.
- 표(board)의 행(row)의 크기 : 1,000 이하의 자연수
- 표(board)의 열(column)의 크기 : 1,000 이하의 자연수
- 표(board)의 값은 1또는 0으로만 이루어져 있습니다.

### 입출력 예

board | answer
:---: | :---: 
[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]] | 9
[[0,0,1,1],[1,1,1,1]] | 4

### 입출력 예 설명

#### 입출력 예 #1

- 위의 예시와 같습니다.

#### 입출력 예 #2

| 0 | 0 | 1 | 1 | 
:---: | :---: | :---: | :---:
| 1 | 1 | 1 | 1 |

로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return합니다.

## 간단한 문제 해설

1 | 1
:---: | :---:
1 | 1

- 위와 같은 경우에 왼쪽, 위, 왼 대각선이 모두 1이면 2로 변할수 있다.
- 즉, 2이면 3으로 가능하다는 것이다.
- 이렇게 모든 값들을 돌면서 확인하면 쉽게 문제가 풀리게 된다.

## 정답

```java
public class FindTheLargestSquare {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(solution(new int[][] {{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                map[row + 1][col + 1] = board[row][col];
            }
        }

        for (int row = 1; row < map.length; row++) {
            for (int col = 1; col < map[0].length; col++) {
                if (map[row][col] != 0) {
                    map[row][col] = Math.min(Math.min(map[row - 1][col], map[row][col - 1]), map[row - 1][col - 1]) + 1;
                }
                answer = Math.max(answer, map[row][col]);
            }
        }

        return answer * answer;
    }
}

```
