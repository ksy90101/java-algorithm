package com.algorithm.menu_renewal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuRenewal {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2, 3, 4})));
        System.out.println(Arrays.toString(
                solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2, 3, 5})));
        System.out.println(Arrays.toString(solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2, 3, 4})));
    }

    public static String[] solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> orderMappers = new HashMap<>();

        for (String order : orders) {
            char[] orderMenus = order.toCharArray();
            for (int menuCount : course) {
                Character[] comArr = new Character[menuCount];
                Map<String, Integer> value = orderMappers.getOrDefault(menuCount, new HashMap<>());
                combination(comArr, orderMenus.length, menuCount, 0, 0, orderMenus, value);
                orderMappers.put(menuCount, value);
            }
        }

        List<String> answer = new ArrayList<>();

        for (Map<String, Integer> value : orderMappers.values()) {
            Integer maxCount = value.values()
                    .stream()
                    .max(Integer::compareTo)
                    .orElse(0);
            if (maxCount < 2) {
                continue;
            }
            for (Map.Entry<String, Integer> value2 : value.entrySet()) {
                if (maxCount.equals(value2.getValue())) {
                    answer.add(value2.getKey());
                }
            }
        }

        answer.sort(String::compareTo);

        return answer.toArray(new String[0]);
    }

    private static void combination(Character[] comArr, int n, int r, int index, int target, char[] arr,
            Map<String, Integer> map) {
        if (r == 0) {
            String value = Arrays.stream(comArr)
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(""));
            map.put(value, map.getOrDefault(value, 0) + 1);
            return;
        }
        if (target == n) {
            return;
        }

        comArr[index] = arr[target];
        combination(comArr, n, r - 1, index + 1, target + 1, arr, map);
        combination(comArr, n, r, index, target + 1, arr, map);
    }
}
