package com.algorithm.basic_string;

public class BasicString {
    public static void main(String[] args) {
        String s1 = "a234";
        String s2 = "1234";
        BasicString basicString = new BasicString();
        System.out.println(basicString.solution(s1));
        System.out.println(basicString.solution(s2));
    }

    public boolean solution(String s) {
        try {
            Integer.parseInt(s);
            return s.length() == 4 || s.length() == 6;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
