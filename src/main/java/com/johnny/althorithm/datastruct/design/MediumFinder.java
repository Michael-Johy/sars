package com.johnny.althorithm.datastruct.design;

import java.util.PriorityQueue;

public class MediumFinder {

    private final PriorityQueue<Integer> large = new PriorityQueue<>();
    private final PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a);

    public void add(int e) {
        if (small.size() >= large.size()) {
            small.add(e);
            large.add(small.poll());
        } else {
            large.add(e);
            small.add(large.poll());
        }
    }

    public double findMedium() {
        if (large.isEmpty() && small.isEmpty()) {
            return -1;
        }
        if (large.size() == small.size()) {
            return (small.peek().doubleValue() + large.peek().doubleValue())/2;
        }
        return large.size() > small.size() ? large.peek() : small.peek();
    }


    public static void main(String[] args) {
        MediumFinder finder = new MediumFinder();
        finder.add(1);
        finder.add(5);
        finder.add(2);
        finder.add(4);
        finder.add(9);
        finder.add(10);

        System.out.println(finder.findMedium());
    }
}
