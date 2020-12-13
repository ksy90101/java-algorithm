package com.algorithm.make_jaden_case;

public class MakeJadenCase {
    public static void main(final String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution("for the last     week"));
    }

    public static String solution(String s) {
        s = s.toLowerCase();
        final String[] splitedS = s.split(" ");
        for (int i = 0; i < splitedS.length; i++) {
            if (splitedS[i].equals("")) {
                continue;
            }
            final char firstCharacter = splitedS[i].charAt(0);
            if (Character.isAlphabetic(firstCharacter)) {
                splitedS[i] = splitedS[i].replace(firstCharacter, Character.toUpperCase(firstCharacter));
            }
        }

        return String.join(" ", splitedS);
    }
}
