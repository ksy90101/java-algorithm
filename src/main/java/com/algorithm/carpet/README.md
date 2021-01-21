# [\[프로그래머스\] 카펫](https://programmers.co.kr/learn/courses/30/lessons/42842)

## 문제 설명

Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

![carpet.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b1ebb809-f333-4df2-bc81-02682900dc2d/carpet.png)

Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한사항

- 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
- 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
- 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

### 입출력 예

brown | yellow | return
:---: | :---: | :---:
10 | 2 | [4, 3]
8 | 1 | [3, 3]
24 | 24 | [8, 6]

[출처](https://hsin.hr/coci/archive/2010_2011/contest4_tasks.pdf)

## 간단한 문제 설명

- 문제해서 조건들을 파악하는 문제라고 생각합니다.
- 일단, 가로와 세로의 가장 최소값은 3일겁니다. 왜냐하면 yellow가 1일 경우는 3 * 3 이기 때문입니다.
- 아울러 가로 * 세로 == brown + yellow이라는 조건도 있을겁니다.
- 아울러 제한사항에서 가로 길이는 세로 길이와 같거나 세로 길이보다 길다 라는 것을 알 수 있습니다.
- 마지막으로 테두리인 brown의 수는 `가로 * 2 + 세로 * 2 - 4`이다는 걸 알 수 있습니다.
- 여기서 -4는 중복값인 테두리의 값이다.

## 정답 코드

```java
import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        for (int horizontal = 3; horizontal < brown / 2; horizontal++) {
            for (int vertical = 3; vertical <= horizontal; vertical++) {
                if ((brown + yellow == horizontal * vertical) && (brown == (horizontal * 2) + (vertical * 2) - 4)) {
                    return new int[] {horizontal, vertical};
                }
            }
        }
        return new int[] {0, 0};
    }
}

```
