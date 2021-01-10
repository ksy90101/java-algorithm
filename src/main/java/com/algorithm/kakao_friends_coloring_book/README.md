# [\[프로그래머스\] 카카오 프렌즈 컬러링북](https://programmers.co.kr/learn/courses/30/lessons/1829)

## 문제 설명

카카오 프렌즈 컬러링북 출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면
색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

![alt text](http://t1.kakaocdn.net/codefestival/apeach.png)

위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

입력 형식 입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.

- 1 <= m, n <= 100 picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
- picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
- 출력 형식 리턴 타입은 원소가 두 개인 정수 배열이다.
- 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

### 예제 입출력

m | n | picture | answer
:---: | :---: | :---: | :---:
6 | 4 | [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]] | [4, 5]

예제에 대한 설명 예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 가장 넓은 영역은 왼쪽 위 1이
차지하는 영역으로 총 5칸이다.

## 문제해설

- DFS를 이용하면 간단하게 풀 수 있는 문제라고 생각합니다.
- 아래의 BFS vs DFS 글을 참고해주세요!
- [BFS vs DFS](https://github.com/ksy90101/TIL/blob/master/computerScience/dfs-vs-bfs.md)

## 정답코드

```java
import java.util.Arrays;
import java.util.Stack;

public class KakaoFriendsColoringBook {
    private static boolean[][] visited;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 4,
                new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
        System.out.println(Arrays.toString(solution(13, 16,
                new int[][] {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                        {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}})));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];

        return bfs(m, n, picture);
    }

    private static int[] bfs(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        Stack<Integer> sx = new Stack<>();
        Stack<Integer> sy = new Stack<>();

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                int count = 0;
                if (picture[row][column] != 0 && !visited[row][column]) {
                    answer[0]++;
                    count++;

                    add(sx, sy, row, column);
                }

                while (!sx.isEmpty()) {
                    int x = sx.pop();
                    int y = sy.pop();

                    if (x > 0 && picture[x - 1][y] == picture[row][column] && !visited[x - 1][y]) {
                        add(sx, sy, x - 1, y);
                        count++;
                    }
                    if (x < m - 1 && picture[x + 1][y] == picture[row][column] && !visited[x + 1][y]) {
                        add(sx, sy, x + 1, y);
                        count++;
                    }
                    if (y > 0 && picture[x][y - 1] == picture[row][column] && !visited[x][y - 1]) {
                        add(sx, sy, x, y - 1);
                        count++;
                    }
                    if (y < n - 1 && picture[x][y + 1] == picture[row][column] && !visited[x][y + 1]) {
                        add(sx, sy, x, y + 1);
                        count++;
                    }
                }
                answer[1] = Math.max(count, answer[1]);
            }
        }

        return answer;
    }

    private static void add(Stack<Integer> sx, Stack<Integer> sy, int x, int y) {
        sx.push(x);
        sy.push(y);
        visited[x][y] = true;
    }
}

```
