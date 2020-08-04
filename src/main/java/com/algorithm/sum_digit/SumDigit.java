package com.algorithm.sum_digit;

public class SumDigit {
    public static void main(String[] args) {
        SumDigit sumDigit = new SumDigit();
        int n1 = 123;
        int n2 = 987;
        System.out.println(sumDigit.solution(n1));
        System.out.println(sumDigit.solution(n2));
    }

    public int solution(int n) {
        int answer = 0;
        while (n != 0) {
            answer += n % 10;
            n = n / 10;
        }
        return answer;
    }
}
