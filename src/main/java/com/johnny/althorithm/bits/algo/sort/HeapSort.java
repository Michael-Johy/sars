package com.johnny.althorithm.bits.algo.sort;

import java.util.PriorityQueue;

/**
 * 堆排序：
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 2, 23, 5, 8, 24, 27, 34, 15, 18};
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int item : arr) {
            queue.add(item);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!queue.isEmpty()) {
                arr[i] = queue.poll();
            }
        }
        for (int item : arr) {
            System.out.println(item);
        }
    }
}
