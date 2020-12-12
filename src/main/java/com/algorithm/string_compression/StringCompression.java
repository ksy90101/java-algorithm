package com.algorithm.string_compression;

public class StringCompression {
    public static void main(final String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(final String s) {
        int min = s.length();
        for (int compressLength = 1; compressLength <= s.length() / 2; compressLength++) {
            final int stringCompression = compress(s, compressLength).length();
            min = Math.min(min, stringCompression);
        }

        return min;
    }

    private static String compress(final String word, final int compressLength) {
        int count = 1;
        final StringBuilder compression = new StringBuilder();
        String parttern = "";

        for (int index = 0; index < word.length() + compressLength; index += compressLength) {
            String nowWord = "";
            if (index >= word.length()) {
                nowWord = "";
            } else if (word.length() < compressLength + index) {
                nowWord = word.substring(index);
            } else {
                nowWord = word.substring(index, index + compressLength);
            }

            if (index != 0) {
                if (nowWord.equals(parttern)) {
                    count++;
                } else if (count >= 2) {
                    compression.append(count)
                            .append(parttern);
                    count = 1;
                } else {
                    compression.append(parttern);
                }
            }
            parttern = nowWord;
        }

        return compression.toString();
    }
}
