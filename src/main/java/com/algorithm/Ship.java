package com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class Ship {
    private final List<Integer> containers;

    public Ship(final int containerCount, final IntFunction<Integer> fillContainer) {
        this.containers = new ArrayList<>();

        for (int i = 0; i < containerCount; i++) {
            this.containers.add(i, fillContainer.apply(i));
        }
    }

    public static void main(final String[] args) {
        final Ship ship = new Ship(10, containerIndex -> containerIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Container: " + i + ", cargo: " + ship.peekContainer(i));
        }
    }

    public int peekContainer(final int containerIndex) {
        return this.containers.get(containerIndex);
    }
}
