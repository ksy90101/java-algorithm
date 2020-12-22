package com.algorithm.joystick;

public class Joystick {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }

    public static int solution(String name) {
        int answer = 0;

        int minMove = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;

            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            minMove = Math.min(minMove, i + name.length() - next + i);
        }

        answer += minMove;

        return answer;
    }
}
