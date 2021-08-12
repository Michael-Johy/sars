package com.johnny.althorithm.sort;

/**
 * 快速排序 O(n*lgn)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 2, 23, 5, 8, 24, 27, 34, 15, 18};
        int k = findK(arr, 0, arr.length - 1, 2);
        for (int item : arr) {
            System.out.println(item);
        }
        System.out.println(k);
    }

    public static int findK(int[] arr, int left, int right, int k) {
        int p = partition(arr, left, right);
        if (p == k - 1) {
            return arr[p];
        } else if (p > k - 1) {
            return findK(arr, left, p - 1, k);
        } else if (p < k - 1) {
            return findK(arr, p + 1, right, k - p);
        }
        return -1;
    }

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (temp >= arr[right] && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (temp <= arr[left] && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = temp;
        return right;
    }
}
