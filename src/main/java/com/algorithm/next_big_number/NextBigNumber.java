package com.algorithm.next_big_number;

public class NextBigNumber {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int number = n;
        int oneNumberOfN = findOneNumber(Integer.toBinaryString(n));
        int oneNumberOfAnswer = -1;

        while (oneNumberOfN != oneNumberOfAnswer) {
            number++;
            oneNumberOfAnswer = findOneNumber(Integer.toBinaryString(number));
        }

        return number;
    }

    private static int findOneNumber(String number) {
        int count = 0;

        for (int i = 0; i < number.length(); i++) {
            if ('1' == number.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
