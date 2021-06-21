package com.johnny.althorithm.bits.algo.dp.beibao;

/**
 * 经典动态规划：子集背包问题， 给定一组元素，是否可以划分成元素和相同的2份
 */
public class SubBeiBaoSolution {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int quyu = sum % 2;
        if (quyu == 1) {
            return false;
        }
        //
        int target = sum / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int w = 1; w <= target; w++) {
                if (w < nums[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - nums[i - 1]] + 1);
                }
            }
        }
        return dp[nums.length][target] != 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        boolean result = canPartition(nums);
        System.out.println(result);
    }
}
