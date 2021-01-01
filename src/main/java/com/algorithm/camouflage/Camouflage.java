package com.algorithm.camouflage;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}}));
    }

    public static int solution(String[][] clothes) {
        int count = 1;
        Map<String, Integer> clotheMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clotheMap.put(clothe[1], clotheMap.getOrDefault(clothe[1], 0) + 1);
        }

        for (Integer clothe : clotheMap.values()) {
            count *= clothe + 1;
        }

        return count - 1;
    }

}
