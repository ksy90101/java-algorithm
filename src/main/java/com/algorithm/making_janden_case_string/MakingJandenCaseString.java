package com.algorithm.making_janden_case_string;

public class MakingJandenCaseString {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution("for the last week  "));
    }

    public static String solution(String s) {
        String[] splitedStrings = s.split(" ", -1);

        for (int i = 0; i < splitedStrings.length; i++) {
            if (splitedStrings[i].isEmpty()) {
                continue;
            }
            splitedStrings[i] = toJandenCase(splitedStrings[i]);
        }

        return String.join(" ", splitedStrings);
    }

    private static String toJandenCase(String str) {
        StringBuilder jandenCase = new StringBuilder();
        char[] charaters = str.toCharArray();

        for (int i = 0; i < charaters.length; i++) {
            if (!Character.isAlphabetic(charaters[i])) {
                jandenCase.append(charaters[i]);
                continue;
            } else if (i == 0) {
                jandenCase.append(Character.toUpperCase(charaters[i]));
                continue;
            }
            jandenCase.append(Character.toLowerCase(charaters[i]));
        }

        return jandenCase.toString();
    }
}
