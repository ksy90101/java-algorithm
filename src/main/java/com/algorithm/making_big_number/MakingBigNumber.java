package com.algorithm.making_big_number;

import java.util.Stack;

public class MakingBigNumber {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("12341234", 3));
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        char[] numbers = number.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < numbers[i]) {
                k--;
                stack.pop();
            }
            stack.push(numbers[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            if (k != 0) {
                stack.pop();
                k--;
            } else {
                stringBuilder.append(stack.pop());
            }
        }

        return stringBuilder.reverse().toString();
    }
}
