# [\[프로그래머스\] 메뉴 리뉴얼](https://programmers.co.kr/learn/courses/30/lessons/72411)

## 문제 설명

레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다. 기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로
결정했습니다. 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 스카피는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다. 단, 코스요리
메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)

손님 번호 | 주문한 단품메뉴 조합
:---: | :---:
1번 손님 | A, B, C, F, G
2번 손님 | A, C
3번 손님 | C, D, E
4번 손님 | A, C, D, E
5번 손님 | B, C, F, G
6번 손님 | A, C, D, E, H

가장 많이 함께 주문된 단품메뉴 조합에 따라 스카피가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.

코스 종류 | 메뉴 구성 | 설명
:---: | :---: | :---:
요리 2개 코스 | A, C | 1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
요리 3개 코스 | C, D, E | 3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
요리 4개 코스 | B, C, F, G | 1번, 5번 손님으로부터 총 2번 주문됐습니다.
요리 4개 코스 | A, C, D, E | 4번, 6번 손님으로부터 총 2번 주문됐습니다.

### [문제]

각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, 스카피가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때, 스카피가 새로 추가하게 될
코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

### [제한사항]

- orders 배열의 크기는 2 이상 20 이하입니다.
- orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
    - 각 문자열은 알파벳 대문자로만 이루어져 있습니다.
    - 각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
- course 배열의 크기는 1 이상 10 이하입니다.
    - course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
    - course 배열에는 같은 값이 중복해서 들어있지 않습니다.

- 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
    - 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
    - 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
    - orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.

### [입출력 예]

orders | course | result
:---: | :---: | :---:
["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"] | [2,3,4] | ["AC", "ACDE", "BCFG", "CDE"]
["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"] | [2,3,5] | ["ACD", "AD", "ADE", "CD", "XYZ"]
["XYZ", "XWY", "WXA"] | [2,3,4] | ["WX", "XY"]

### 입출력 예에 대한 설명

#### 입출력 예 #1

문제의 예시와 같습니다.

#### 입출력 예 #2

- AD가 세 번, CD가 세 번, ACD가 두 번, ADE가 두 번, XYZ 가 두 번 주문됐습니다.
- 요리 5개를 주문한 손님이 1명 있지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 5개로 구성된 코스요리는 새로 추가하지 않습니다.

#### 입출력 예 #3

- WX가 두 번, XY가 두 번 주문됐습니다.
- 3명의 손님 모두 단품메뉴를 3개씩 주문했지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 3개로 구성된 코스요리는 새로 추가하지 않습니다.
- 또, 단품메뉴를 4개 이상 주문한 손님은 없으므로, 요리 4개로 구성된 코스요리 또한 새로 추가하지 않습니다.

## 문제 해설

- [Permutation Algorithm(순열 알고리즘) & Combination Algorithm(조합 알고리즘)](https://rutgo-letsgo.tistory.com/221)
- 조합 알고리즘을 통해 course에 있는 모든 조합을 구한다. 이때 조합을 구할때 중복값을 제거하기 위해 sorted를 통해 메뉴 세트의 중복을 없앤다.
- 각 2명 이상 주문한 메뉴이여야 하며, 각 세트 메뉴 수 중 가장 많이 주문한 메뉴세트만 보여줘야 하기 때문에 해당 예외도 처리하면 된다.
- 조합 알고리즘을 알고 있다면 쉽게 문제를 접근할 수 있지만, 모른다면 풀기 어려운 문제라고 생각한다.

## 정답코드

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuRenewal {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4})));
        System.out.println(Arrays.toString(
                solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5})));
        System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2, 3, 4})));
    }

    public static String[] solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> orderMappers = new HashMap<>();

        for (String order : orders) {
            char[] orderMenus = order.toCharArray();
            for (int menuCount : course) {
                Character[] comArr = new Character[menuCount];
                Map<String, Integer> value = orderMappers.getOrDefault(menuCount, new HashMap<>());
                combination(comArr, orderMenus.length, menuCount, 0, 0, orderMenus, value);
                orderMappers.put(menuCount, value);
            }
        }

        List<String> answer = new ArrayList<>();

        for (Map<String, Integer> value : orderMappers.values()) {
            Integer maxCount = value.values()
                    .stream()
                    .max(Integer::compareTo)
                    .orElse(0);
            if (maxCount < 2) {
                continue;
            }
            for (Map.Entry<String, Integer> value2 : value.entrySet()) {
                if (maxCount.equals(value2.getValue())) {
                    answer.add(value2.getKey());
                }
            }
        }

        answer.sort(String::compareTo);

        return answer.toArray(new String[0]);
    }

    private static void combination(Character[] comArr, int n, int r, int index, int target, char[] arr,
            Map<String, Integer> map) {
        if (r == 0) {
            String value = Arrays.stream(comArr)
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(""));
            map.put(value, map.getOrDefault(value, 0) + 1);
            return;
        }
        if (target == n) {
            return;
        }

        comArr[index] = arr[target];
        combination(comArr, n, r - 1, index + 1, target + 1, arr, map);
        combination(comArr, n, r, index, target + 1, arr, map);
    }
}

```
