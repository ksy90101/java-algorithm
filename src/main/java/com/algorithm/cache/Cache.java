package com.algorithm.cache;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public static void main(String[] args) {
        System.out.println(solution(3,
                new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3,
                new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2,
                new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
                        "Jeju", "NewYork",
                        "Rome"}));
        System.out.println(solution(5,
                new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
                        "Jeju", "NewYork",
                        "Rome"}));
        System.out.println(solution(2,
                new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0,
                new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (String city : cities) {
            city = city.toLowerCase();
            if (queue.contains(city)) {
                answer += 1;
                queue.remove(city);
            } else {
                if (queue.size() == cacheSize) {
                    queue.poll();
                }
                answer += 5;
            }
            queue.add(city);
        }
        return answer;
    }
}
