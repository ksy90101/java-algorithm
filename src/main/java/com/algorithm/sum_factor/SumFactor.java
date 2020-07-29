package com.algorithm.sum_factor;

public class SumFactor {
    public static void main(String[] args) {
        SumFactor sumFactor = new SumFactor();
        int n1 = 12;
        int n2 = 5;
        System.out.println(sumFactor.solution(n1));
        System.out.println(sumFactor.solution(n2));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}
