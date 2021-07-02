package com.johnny.althorithm.bits.algo.sort;

/**
 * 选择排序：每次选择最小或最大的放在排序序列最前面
 * O(n2)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 2, 23, 5, 8, 24, 27, 34, 15, 18};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minV = arr[i];
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minV) {
                    minI = j;
                    minV = arr[j];
                }
            }
            if (minI != i) {
                // change
                int temp = arr[i];
                arr[i] = arr[minI];
                arr[minI] = temp;
            }
        }
    }
}
