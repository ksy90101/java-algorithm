package com.algorithm.mysortingstring;

import java.util.Arrays;

public class MySortingString {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            } else if (a.charAt(n) != b.charAt(n)) {
                return a.charAt(n) > b.charAt(n) ? 1 : -1;
            }
            return 0;
        });

        return strings;
    }

    public static void main(String[] args) {
        MySortingString mySortingString = new MySortingString();
        String[] strings1 = {"sun", "bed", "car"};
        int n1 = 1;
        String[] strings2 = {"abce", "abcd", "cdx"};
        int n2 = 2;

        System.out.println(Arrays.toString(mySortingString.solution(strings1, n1)));
        System.out.println(Arrays.toString(mySortingString.solution(strings2, n2)));
    }
}
