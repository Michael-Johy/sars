package com.johnny.althorithm.bits.algo.dp.dajiajieshe;

import java.util.Arrays;

/**
 * 问题1:
 * 给定一个非空数组，相邻2家不可同时打劫，求能够窃取的最大金额
 * 问题2:
 * 给定一个环型数组，相邻2家不可同时打劫，求能够窃取的最大金额
 * 分析：第一个抢，最后一个不抢
 * 第一个不抢，最后一个抢
 * 第一个和最后一个都不抢
 * <p>
 */
public class Solution {

    /**
     * 自低向上
     */
    public int rob(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = prices[0];
        dp[1] = Math.max(prices[0], prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + prices[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public int rob2(int[] prices) {
        int[] memo = new int[prices.length];
        Arrays.fill(memo, -1);
        return dp(prices, 0, memo);
    }

    private int dp(int[] prices, int start, int[] memo) {
        if (start >= prices.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(dp(prices, start + 1, memo),
                dp(prices, start + 2, memo) + prices[start]);
        memo[start] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 1};
        Solution s = new Solution();
        int max = s.rob(prices);
        System.out.println("rob1 = " + max);

        int max2 = s.rob2(prices);
        System.out.println("rob2 = " + max2);
    }

}
