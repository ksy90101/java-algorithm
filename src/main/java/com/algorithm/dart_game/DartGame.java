package com.algorithm.dart_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Score {
    SINGLE("S") {
        @Override
        public int apply(final int number) {
            return (int)Math.pow(number, 1);
        }
    }, DOUBLE("D") {
        @Override
        public int apply(final int number) {
            return (int)Math.pow(number, 2);
        }
    }, TRIPLE("T") {
        @Override
        public int apply(final int number) {
            return (int)Math.pow(number, 3);
        }
    }, STAR("*") {
        @Override
        public int apply(final int number) {
            return number * 2;
        }
    }, AHCHA("#") {
        @Override
        public int apply(final int number) {
            return number * -1;
        }
    };

    private final String symbol;

    Score(final String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int number);

    public boolean isSymbol(final String symbol) {
        return this.symbol.equals(symbol);
    }
}

public class DartGame {

    public static void main(final String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }

    public static int solution(final String dartResult) {
        final List<Integer> results = new ArrayList<>();
        final String[] splitedDartResult = dartResult.split("");
        final StringBuilder score = new StringBuilder();

        for (final String dartResultValue : splitedDartResult) {
            if (Arrays.stream(Score.values()).noneMatch(n -> n.isSymbol(dartResultValue))) {
                score.append(dartResultValue);
                continue;
            }
            final Score symbol = Arrays.stream(Score.values())
                    .filter(n -> n.isSymbol(dartResultValue))
                    .findFirst()
                    .get();
            if (symbol == Score.STAR) {
                if (results.size() > 1) {
                    results.set(results.size() - 2, symbol.apply(results.get(results.size() - 2)));
                }
                results.set(results.size() - 1, symbol.apply(results.get(results.size() - 1)));
                continue;
            } else if (symbol == Score.AHCHA) {
                results.set(results.size() - 1, symbol.apply(results.get(results.size() - 1)));
                continue;
            }
            results.add(symbol.apply(Integer.parseInt(score.toString())));
            score.delete(0, score.length());
        }

        return results.stream().mapToInt(n -> n).sum();
    }

}
