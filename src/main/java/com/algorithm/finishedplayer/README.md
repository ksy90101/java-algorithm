# [\[프로그래머스\] 완주하지 못한 선수](https://programmers.co.kr/learn/courses/30/lessons/42576)

## 문제

**문제 설명**

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

**제한사항**

마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.

completion의 길이는 participant의 길이보다 1 작습니다.

참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.

참가자 중에는 동명이인이 있을 수 있습니다.

**입출력 예**

| participant | completion | return |
| :-: | :-: | :-: |
| \[leo, kiki, eden\] | \[eden, kiki\] | leo |
| \[marina, josipa, nikola, vinko, filipa\] | \[josipa, filipa, marina, nikola\] | vinko |
| \[mislav, stanko, mislav, ana\] | \[stanko, ana, mislav\] | mislav |

**입출력 예 설명**

예제 #1

leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2

vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3

mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

## 풀이 

```java
package com.algorithm.finishedplayer;

import java.util.HashMap;
import java.util.Map;

public class FinishedPlayer {
	public String solution(String[] participants, String[] completions) {
		Map<String, Integer> map = new HashMap<>();

		String result = "";
		for (String participant : participants){
			map.put(participant, map.getOrDefault(participant, 0) + 1); // 값이 없다면 0, 있다면 있는 값에서 + 1
		}

		for (String completion : completions){ // 순회하면서 -1씩, 이렇게 하는 이유가 동명이인이 있기 때문이다.
			map.replace(completion, map.get(completion) - 1);
		}

		for (String participant : participants){
			if(map.get(participant) != 0){
				result = participant;
				break;
			}
		}

		return result;
	}

	// Test Case
	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"marina", "josipa", "nikola", "filipa"};
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "mislav", "ana"};

		FinishedPlayer solution = new FinishedPlayer();
		System.out.println(solution.solution(participant1, completion1));
		System.out.println(solution.solution(participant2, completion2));
		System.out.println(solution.solution(participant3, completion3));
	}
}
```