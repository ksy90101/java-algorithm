package com.algorithm.find_kim_seoul;

import java.util.Arrays;

public class FindKimSeoul {
    public static void main(String[] args) {
        FindKimSeoul findKimSeoul = new FindKimSeoul();
        String[] seoul = {"Jane", "Kim"};
        System.out.println(findKimSeoul.solution(seoul));
    }

    public String solution(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf("Kim");

        return String.format("김서방은 %d에 있다", index);
    }
}
