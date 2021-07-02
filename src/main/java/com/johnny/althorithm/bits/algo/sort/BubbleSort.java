package com.johnny.althorithm.bits.algo.sort;

/**
 * 冒泡排序 O(n2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 2, 23, 5, 8, 24, 27, 34, 15, 18};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //需要找出最大的arr.length-1个数
            for (int j = 0; j < arr.length - 1 - i; j++) { //需要比较多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
