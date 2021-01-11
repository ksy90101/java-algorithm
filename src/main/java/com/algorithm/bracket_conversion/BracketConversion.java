package com.algorithm.bracket_conversion;

public class BracketConversion {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        return makeString(p);
    }

    public static String makeString(String w) {
        if (w.isEmpty()) {
            return "";
        }

        int cutIndex = division(w);
        String u = w.substring(0, cutIndex);
        String v = w.substring(cutIndex);

        if (isCorrect(u)) {
            return u + makeString(v);
        }

        String temp = "(" + makeString(v) + ")";
        u = u.substring(1, u.length() - 1);
        u = reverse(u);

        return temp + u;
    }

    private static String reverse(String u) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stringBuilder.append(')');
                continue;
            }
            stringBuilder.append('(');
        }

        return stringBuilder.toString();
    }

    public static int division(String w) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                return i + 1;
            }
        }

        return -1;
    }

    private static boolean isCorrect(String u) {
        int count = 0;

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
