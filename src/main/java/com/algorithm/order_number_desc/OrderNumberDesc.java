package com.algorithm.order_number_desc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderNumberDesc {
    public static void main(String[] args) {
        OrderNumberDesc orderNumberDesc = new OrderNumberDesc();
        long n = 118372;
        System.out.println(orderNumberDesc.solution(n));
    }

    public long solution(long n) {
        List<Long> numbers = new ArrayList<>();
        while (n != 0) {
            numbers.add(n % 10);
            n = n / 10;
        }
        numbers.sort(Collections.reverseOrder());
        String number = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
        return Long.parseLong(number);
    }
}
