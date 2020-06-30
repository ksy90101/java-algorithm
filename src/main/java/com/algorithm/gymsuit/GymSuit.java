package com.algorithm.gymsuit;

public class GymSuit {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		for (int i = 0; i < reserve.length; i++){
			if(reserve[i] == -1){ // 성능향상
				continue;
			}
			for (int j = 0; j < lost.length; j++){
				if(lost[j] == -1){ // 성능 향상
					continue;
				}
				if(reserve[i] == lost[j]){ // 중복값 제거
					reserve[i] = -1;
					lost[j] = -1;
					answer++;
					break;
				}
			}
		}
		for (int i = 0; i < reserve.length; i++){
			if(reserve[i] == -1){ // 성능향상
				continue;
			}
			for (int j = 0; j< lost.length; j++){
				if(lost[j] == -1){ // 성능향상
					continue;
				}
				if(Math.abs(lost[j] - reserve[i]) == 1){ // 옆자리인 사람 찾기
					lost[j] = -1;
					reserve[i] = -1;
					answer++;
					break;
				}
			}
		}
		return answer;
	}

	// Test Case
	public static void main(String[] args) {
		int n1 = 5;
		int[] lost1 = {2, 4};
		int[] reserve1 = {1, 3, 5};

		int n2 = 7;
		int[] lost2 = {2, 4, 1};
		int[] reserve2 = {3, 4};

		int n3 = 3;
		int[] lost3 = {3};
		int[] reserve3 = {1};

		GymSuit solution = new GymSuit();
		System.out.println(solution.solution(n1, lost1, reserve1));
		System.out.println(solution.solution(n2, lost2, reserve2));
		System.out.println(solution.solution(n3, lost3, reserve3));
	}
}