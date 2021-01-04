package com.algorithm.phone_ketmon;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneKetmon {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 1, 2, 3}));
        System.out.println(solution(new int[] {3, 3, 3, 2, 2, 4}));
        System.out.println(solution(new int[] {3, 3, 3, 2, 2, 2}));
    }

    public static int solution(int[] nums) {
        int maxKinds = nums.length / 2;
        Set<Integer> phoneKetmons = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        return Math.min(phoneKetmons.size(), maxKinds);
    }
}
