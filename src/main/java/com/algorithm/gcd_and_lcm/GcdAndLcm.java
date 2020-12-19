package com.algorithm.gcd_and_lcm;

import java.util.Arrays;

public class GcdAndLcm {
    public static void main(final String[] args) {
        final int n1 = 3;
        final int m1 = 12;
        final int n2 = 2;
        final int m2 = 5;

        System.out.println(Arrays.toString(solution(n1, m1)));
        System.out.println(Arrays.toString(solution(n2, m2)));
    }

    public static int[] solution(final int n, final int m) {
        final int gcd = getGcd(n, m);
        final int lcm = (n * m) / gcd;

        return new int[] {gcd, lcm};
    }

    private static int getGcd(int n, int m) {
        while (n > 0) {
            final int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
}
