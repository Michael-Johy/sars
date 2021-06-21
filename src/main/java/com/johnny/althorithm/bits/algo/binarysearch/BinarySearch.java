package com.johnny.althorithm.bits.algo.binarysearch;

/**
 * 二分搜索e
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{2, 3, 4, 5};
        int a = binarySearch.rightBound(nums, 1);
        System.out.println(a);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return target;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] > target || nums[right] < target) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return target;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (nums[left] != target || left > (nums.length - 1)) {
            return -1;
        }
        return left;
    }

    public int rightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return target;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
