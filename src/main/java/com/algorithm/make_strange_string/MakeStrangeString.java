package com.algorithm.make_strange_string;

public class MakeStrangeString {
    public static void main(String[] args) {
        MakeStrangeString makeStrangeString = new MakeStrangeString();
        String s = "try hello world";

        System.out.println(makeStrangeString.solution(s));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        String[] split = s.split("");

        for (String str : split) {
            if (str.contains(" ")) {
                index = 0;
                answer.append(" ");
                continue;
            }
            if (index % 2 == 0) {
                answer.append(str.toUpperCase());
                index++;
                continue;
            }
            answer.append(str.toLowerCase());
            index++;
        }
        return answer.toString();
    }
}
