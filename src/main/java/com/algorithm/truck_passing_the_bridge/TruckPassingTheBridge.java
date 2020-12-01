package com.algorithm.truck_passing_the_bridge;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TruckPassingTheBridge {
    public static void main(final String[] args) {
        System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[] {10}));
        System.out.println(solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(final int bridge_length, final int weight, final int[] truck_weights) {
        int answer = 0;
        int truckWeightSum = 0;
        final Queue<Integer> bridge = new ConcurrentLinkedQueue<>();
        for (final int truck_weight : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck_weight);
                    answer++;
                    truckWeightSum += truck_weight;
                    break;
                } else if (bridge.size() == bridge_length) {
                    truckWeightSum -= bridge.poll();
                } else {
                    if (truck_weight + truckWeightSum > weight) {
                        answer++;
                        bridge.offer(0);
                    } else {
                        bridge.offer(truck_weight);
                        answer++;
                        truckWeightSum += truck_weight;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
