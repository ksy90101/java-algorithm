package com.algorithm.string_sort_decs;

import java.util.Arrays;
import java.util.Collections;

public class StringSortDesc {
    public String solution(String s) {
        String[] sArray = s.split("");
        Arrays.sort(sArray, Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (String sValue : sArray) {
            stringBuilder.append(sValue);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "Zbcdefg";
        StringSortDesc stringSortDesc = new StringSortDesc();
        System.out.println(stringSortDesc.solution(s));
    }
}
