package com.algorithm.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ranking {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[] {"java backend junior pizza 150", "python frontend senior chicken 210",
                        "python frontend senior chicken 150", "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"}, new String[] {"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150", "- and - and - and chicken 100",
                        "- and - and - and - 150"})));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Member> members = new ArrayList<>();
        for (String memberInfo : info) {
            String[] splitedMemberInfo = memberInfo.split(" ");
            members.add(
                    new Member(splitedMemberInfo[0], splitedMemberInfo[1], splitedMemberInfo[2], splitedMemberInfo[3],
                            splitedMemberInfo[4]));
        }

        for (int i = 0; i < query.length; i++) {
            String condition = query[i];
            String[] splitedCondition = condition.split(" ");
            String[] conditions = Arrays.stream(splitedCondition)
                    .filter(value -> !value.equals("and"))
                    .toArray(String[]::new);

            long count = members.stream()
                    .filter(member -> member.isMember(
                            conditions[0], conditions[1], conditions[2], conditions[3],
                            conditions[4]
                    )).count();

            answer[i] = (int)count;
        }
        return answer;
    }
}

class Member {
    private String language;
    private String field;
    private String career;
    private String food;
    private int score;

    public Member(String language, String field, String career, String food, String score) {
        this.language = language;
        this.field = field;
        this.career = career;
        this.food = food;
        this.score = Integer.parseInt(score);
    }

    public boolean isMember(String language, String field, String career, String food, String score) {
        if (!"-".equals(language) && !language.equals(this.language)) {
            return false;
        }
        if (!"-".equals(field) && !field.equals(this.field)) {
            return false;
        }
        if (!"-".equals(career) && !career.equals(this.career)) {
            return false;
        }
        if (!"-".equals(food) && !food.equals(this.food)) {
            return false;
        }
        return "-".equals(score) || Integer.parseInt(score) <= this.score;
    }
}
