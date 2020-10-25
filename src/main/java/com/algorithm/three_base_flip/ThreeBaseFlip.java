package com.algorithm.three_base_flip;

public class ThreeBaseFlip {
    public static void main(final String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }

    public static int solution(int n) {
        final StringBuilder threeBase = new StringBuilder();
        int answer = 0;
        while (n != 0) {
            threeBase.append(n % 3);
            n = n / 3;
        }

        final String[] splitThreeBase = threeBase.reverse()
                .toString()
                .split("");

        for (int i = 0; i < splitThreeBase.length; i++) {
            answer += Integer.parseInt(splitThreeBase[i]) * Math.pow(3, i);
        }
        return answer;
    }
}
