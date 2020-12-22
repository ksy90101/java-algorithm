package com.algorithm.find_prime_numbers;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumbers {
    private static boolean[] visited;
    private static Set<Integer> primeNumbers;
    private static char[] chars;

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];
        primeNumbers = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            chars = new char[i];
            perm(0, i, numbers.length(), numbers);
        }

        return primeNumbers.size();
    }

    private static void perm(int start, int r, int n, String numbers) {
        if (start == r) {
            if (chars[0] == '0') {
                return;
            }

            int number = Integer.parseInt(String.valueOf(chars));

            if (isPrimeNumber(number)) {
                primeNumbers.add(number);
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            chars[start] = numbers.charAt(i);
            perm(start + 1, r, n, numbers);
            visited[i] = false;
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        int end = (int)Math.sqrt(number);
        for (int i = 2; i <= end; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
