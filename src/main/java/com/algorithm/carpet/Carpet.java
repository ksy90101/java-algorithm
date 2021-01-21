package com.algorithm.carpet;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        for (int horizontal = 3; horizontal < brown / 2; horizontal++) {
            for (int vertical = 3; vertical <= horizontal; vertical++) {
                if ((brown + yellow == horizontal * vertical) && (brown == (horizontal * 2) + (vertical * 2) - 4)) {
                    return new int[] {horizontal, vertical};
                }
            }
        }
        return new int[] {0, 0};
    }
}
