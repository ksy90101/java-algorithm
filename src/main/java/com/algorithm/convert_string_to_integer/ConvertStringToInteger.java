package com.algorithm.convert_string_to_integer;

public class ConvertStringToInteger {
    public static void main(String[] args) {
        ConvertStringToInteger convertStringToInteger = new ConvertStringToInteger();
        String str1 = "1234";
        String str2 = "-1234";
        System.out.println(convertStringToInteger.solution(str1));
        System.out.println(convertStringToInteger.solution(str2));
    }

    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
