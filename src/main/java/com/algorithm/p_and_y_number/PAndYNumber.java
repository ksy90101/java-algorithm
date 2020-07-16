package com.algorithm.p_and_y_number;

public class PAndYNumber {
    boolean solution(String s) {
        String[] sArray = s.toLowerCase().split("");
        int p = 0;
        int y = 0;
        for (String sValue : sArray) {
            if (sValue.equals("p")) {
                p++;
            } else if (sValue.equals("y")) {
                y++;
            }
        }
        return p == y;
    }

    public static void main(String[] args) {
        PAndYNumber pAndYNumber = new PAndYNumber();
        String s1 = "pPoooyY";
        String s2 = "Pyy";
        System.out.println(pAndYNumber.solution(s1));
        System.out.println(pAndYNumber.solution(s2));
    }
}
