package com.johnny.althorithm.bits.algo.sort;

/**
 * 归并排序是稳定排序算法，时间复杂度O(nlgn)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 4, 5, 1, 3, 2};
        int[] temp = new int[arr.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1, temp);
    }

    public void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }
}
