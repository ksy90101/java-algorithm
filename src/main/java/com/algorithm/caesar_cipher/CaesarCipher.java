package com.algorithm.caesar_cipher;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        String s1 = "AB";
        int n1 = 1;
        String s2 = "z";
        int n2 = 1;
        String s3 = "a B z";
        int n3 = 4;

        System.out.println(caesarCipher.solution(s1, n1));
        System.out.println(caesarCipher.solution(s2, n2));
        System.out.println(caesarCipher.solution(s3, n3));
    }

    public String solution(String s, int n) {
        List<Character> toLowerChar = new ArrayList<>();
        List<Character> toUpperChar = new ArrayList<>();
        char[] split = s.toCharArray();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            toLowerChar.add((char)('a' + i));
            toUpperChar.add((char)('A' + i));
        }

        for (char value : split) {
            if (toUpperChar.contains(value)) {
                int index = (toUpperChar.indexOf(value) + n) % 26;
                answer.append(toUpperChar.get(index));
                continue;
            } else if (toLowerChar.contains(value)) {
                int index = (toLowerChar.indexOf(value) + n) % 26;
                answer.append(toLowerChar.get(index));
                continue;
            }
            answer.append(value);
        }
        return answer.toString();
    }
}
