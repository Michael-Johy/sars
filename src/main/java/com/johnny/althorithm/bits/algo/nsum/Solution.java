package com.johnny.althorithm.bits.algo.nsum;


import java.util.Arrays;
import java.util.Vector;

/**
 * 求解NSum问题
 * 1.数据排序。Arrays.sort(nums)
 * 2.用到双指针、Arrays.copyOfRange(nums, 0, nums.length-1)
 * 3.t(nums, count, target) = t(nums[1:length-1], count-1, target-nums[0])
 * 其中：nums表示数据、count表示几个数求和、target表示count个数表示的和
 * 4.最终递归到count=2时返回
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return result;
    }

    private Vector<Vector<Integer>> doTwoSumNotDuplicate(int[] nums, int target) {
        Vector<Vector<Integer>> result = new Vector<>();
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int lv = nums[left];
            int rv = nums[right];
            int sum = lv + rv;

            if (sum == target) {
                Vector<Integer> item = new Vector<>();
                item.add(lv);
                item.add(rv);
                result.add(item);
                do {
                    right = right - 1;
                } while (left < right && nums[right] == rv);
                do {
                    left = left + 1;
                } while (left < right && nums[left] == lv);
            } else if (sum > target) {
                do {
                    right = right - 1;
                } while (left < right && nums[right] == rv);
            } else {
                do {
                    left = left + 1;
                } while (left < right && nums[left] == lv);
            }
        }
        return result;
    }

    public Vector<Vector<Integer>> doNSumNotDuplicate(int[] nums, int count, int target) {
        if (count == 2) {
            return doTwoSumNotDuplicate(nums, target);
        }
        Vector<Vector<Integer>> result = new Vector<>();
        int myCount = count - 1;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            Vector<Vector<Integer>> others = doNSumNotDuplicate(Arrays.copyOfRange(nums, i + 1, nums.length), myCount, target - v);
            for (Vector<Integer> other : others) {
                other.add(v);
                result.add(other);
            }
        }

        return result;
    }

    public Vector<Vector<Integer>> nSumNotDuplicate(int[] nums, int count, int target) {
        Arrays.sort(nums);
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                slow++;
                if (slow != fast) {
                    nums[slow] = nums[fast];
                }
            }
        }
        nums = Arrays.copyOfRange(nums, 0, slow + 1);
        return doNSumNotDuplicate(nums, count, target);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0, 1, 2, 2, 3, 5, 3, 1, 4, 6, 7, 8};

        Vector<Vector<Integer>> result1 = s.nSumNotDuplicate(nums, 2, 4);
        System.out.println(result1);

        Vector<Vector<Integer>> result2 = s.nSumNotDuplicate(nums, 4, 10);
        System.out.println(result2);
    }
}
