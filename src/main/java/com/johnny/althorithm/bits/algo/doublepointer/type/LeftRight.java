package com.johnny.althorithm.bits.algo.doublepointer.type;

import java.util.Arrays;

public class LeftRight {
    public static void main(String[] args) {
        LeftRight leftRight = new LeftRight();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(leftRight.sum(nums, 7)));
    }

    public int[] sum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (target == nums[left] + nums[right]) {
                return new int[]{left, right};
            } else if (target > nums[left] + nums[right]) {
                left++;
            } else if (target < nums[left] + nums[right]) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
