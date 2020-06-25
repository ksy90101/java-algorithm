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
