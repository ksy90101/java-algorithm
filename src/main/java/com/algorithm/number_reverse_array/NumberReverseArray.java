package com.algorithm.number_reverse_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberReverseArray {
    public static void main(String[] args) {
        NumberReverseArray numberReverseArray = new NumberReverseArray();
        int n = 12345;
        System.out.println(Arrays.toString(numberReverseArray.solution(n)));
    }

    public int[] solution(long n) {
        List<Long> answer = new ArrayList<>();
        while (n != 0) {
            answer.add(n % 10);
            n = n / 10;
        }
        return answer.stream().mapToInt(Long::intValue).toArray();
    }
}
