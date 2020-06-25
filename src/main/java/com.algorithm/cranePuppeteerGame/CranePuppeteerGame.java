package com.algorithm.cranePuppeteerGame;

import java.util.Stack;

public class CranePuppeteerGame {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> basket = new Stack<>();

		for (int move : moves) {
			move--; // 인덱스를 위해 추가
			for (int[] row : board) {
				if (row[move] == 0) { // 0은 인형이 없기 때문에 pass(효율성을 위해)
					continue;
				}

				if (!basket.empty() && basket.peek() == row[move]) { // 스택은 비어있을때 peek나 pop을 하면 예외를 발생시킨다. 따라서 방어해줘야 한다.
					// 맨 위에 있는 값이 이번값과 같다면 그냥 빼버린다. 넣을 필요도 없다.
					basket.pop();
					answer += 2;
					row[move] = 0;
					break;
				}
				basket.push(row[move]);
				row[move] = 0;
				break;
			}
		}
		return answer;
	}

	// TestCase
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		CranePuppeteerGame cranePuppeteerGame = new CranePuppeteerGame();
		System.out.println(cranePuppeteerGame.solution(board, moves));
	}
}
