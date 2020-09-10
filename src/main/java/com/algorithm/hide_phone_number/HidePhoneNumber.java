package com.algorithm.hide_phone_number;

public class HidePhoneNumber {
    public static void main(final String[] args) {
        final String phoneNumber1 = "0103334444";
        final String phoneNumber2 = "027778888";

        System.out.println(solution(phoneNumber1));
        System.out.println(solution(phoneNumber2));
    }

    public static String solution(final String phone_number) {
        final StringBuilder answer = new StringBuilder();
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer.append("*");
        }
        answer.append(phone_number.substring(phone_number.length() - 4));

        return answer.toString();
    }
}
