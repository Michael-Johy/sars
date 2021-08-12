package com.johnny.java.collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        for (Integer a : queue){
            System.out.println(a);
        }
    }

}
