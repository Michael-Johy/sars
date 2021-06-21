package com.johnny.althorithm.bits.algo.dp.longestIncSub;

import java.util.Arrays;

public class LongestIncSub {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 3, 4};
        LongestIncSub longestIncSub = new LongestIncSub();
        System.out.println("num[i]结尾 = " + longestIncSub.max(nums));
        System.out.println("num[i]前i个元素 = " + longestIncSub.max2(nums));
    }

    /**
     * O(n*n)
     * dp[i]表示以num[i]为结尾的最长递增子序列, num[i]包含在内
     */
    public int max(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 错误
     * dp[i] 表示前i个元素最长递增子序列
     * max[i] 表示最大元素
     */
    public int max2(int[] nums) {
        int[] dp = new int[nums.length];
        int[] max = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(max, Integer.MIN_VALUE);

        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max[i] = nums[i];
            } else {
                dp[i] = dp[i - 1];
                max[i] = max[i - 1];
            }
        }
        return dp[nums.length - 1];
    }
}
