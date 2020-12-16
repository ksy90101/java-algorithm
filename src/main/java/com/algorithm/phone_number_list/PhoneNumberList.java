package com.algorithm.phone_number_list;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[] {"123", "456", "789"}));
        System.out.println(solution(new String[] {"12", "123", "1235", "567", "88"}));
    }

    public static boolean solution(String[] phone_book) {
        Map<String, String> phones = new HashMap<>();

        for (String phone : phone_book) {
            phones.put(phone, "prefix");
        }

        for (String phone : phone_book) {
            for (int index = 0; index < phone.length(); index++) {
                String a = phone.substring(0, index);
                if (phones.containsKey(a)) {
                    return false;
                }
            }
        }

        return true;
    }
}
