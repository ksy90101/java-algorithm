package com.algorithm.skill_tree;

public class SkillTree {
    public static void main(final String[] args) {
        System.out.println(solution("CDB", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(final String skill, final String[] skill_trees) {
        int answer = skill_trees.length;
        for (final String skillTree : skill_trees) {
            int beforeIndex = skillTree.indexOf(skill.charAt(0));

            for (int i = 1; i < skill.length(); i++) {
                final int currentIndex = skillTree.indexOf(skill.charAt(i));
                if ((beforeIndex > currentIndex && currentIndex != -1) || (beforeIndex == -1 && currentIndex != -1)) {
                    answer--;
                    break;
                }
                beforeIndex = currentIndex;
            }
        }
        return answer;
    }
}
