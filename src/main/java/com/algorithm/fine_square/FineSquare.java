package com.algorithm.fine_square;

import java.math.BigInteger;

public class FineSquare {
    public static void main(final String[] args) {
        System.out.println(solution(8, 16));
    }

    public static long solution(final long w, final long h) {
        final long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        return (w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);
    }
}
