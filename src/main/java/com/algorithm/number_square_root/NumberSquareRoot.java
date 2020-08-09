package com.algorithm.number_square_root;

public class NumberSquareRoot {
    public static void main(String[] args) {
        NumberSquareRoot numberSquareRoot = new NumberSquareRoot();
        long n1 = 121;
        long n2 = 3;
        System.out.println(numberSquareRoot.solution(n1));
        System.out.println(numberSquareRoot.solution(n2));
    }

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        int intSqrt = (int)Math.sqrt(n);

        if (sqrt == intSqrt) {
            return (long)Math.pow(intSqrt + 1, 2);
        }
        return -1;
    }
}
