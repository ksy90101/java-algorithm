package com.algorithm.find_prime;

public class FindPrime {
    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();
        int n1 = 10;
        int n2 = 5;
        System.out.println(findPrime.solution(n1));
        System.out.println(findPrime.solution(n2));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
