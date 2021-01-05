package com.algorithm.english_ending;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class EnglishEnding {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,
                new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" })));
        System.out.println(Arrays.toString(solution(5,
                new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                        "establish", "hang", "gather", "refer", "reference", "estimate", "executive" })));
        System.out.println(Arrays.toString(solution(2,
                new String[] {"hello", "one", "even", "never", "now", "world", "draw" })));
    }

    public static int[] solution(int n, String[] words) {
        Deque<String> endingWords = new ArrayDeque<>();
        endingWords.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            int order = i % n + 1;
            int time = i / n + 1;
            String preWord = endingWords.peekLast();
            if (endingWords.contains(words[i]) || preWord.charAt(preWord.length() - 1) != words[i].charAt(0)) {
                return new int[] {order, time};
            }

            endingWords.add(words[i]);
        }
        return new int[] {0, 0};
    }
}
