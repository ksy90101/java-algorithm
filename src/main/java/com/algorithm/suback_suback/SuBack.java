package com.algorithm.suback_suback;

public class SuBack {
    public static void main(String[] args) {
        SuBack suBack = new SuBack();
        int n1 = 3;
        int n2 = 4;

        System.out.println(suBack.solution(n1));
        System.out.println(suBack.solution(n2));
    }

    public String solution(int n) {
        int number = n / 2;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < number; i++) {
            answer.append("수박");
        }
        if (n % 2 != 0) {
            return answer.append("수").toString();
        }
        return answer.toString();
    }
}
