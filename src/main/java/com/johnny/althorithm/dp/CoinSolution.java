package com.johnny.althorithm.dp;

import java.util.Arrays;

/**
 * 凑硬币问题：状态是总金额，选择时硬币的种类
 * 硬币个数选择最少的
 */
public class CoinSolution {

    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        return dp(coins, amount, memo);
    }

    private int dp(int[] coins, int amount, int[] memo) {
        if (amount <= 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }
            int pre = dp(coins, amount - coin, memo);
            if (pre == -1) {
                continue;
            }
            result = Math.min(result, pre + 1);
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        memo[amount] = result;
        return result;
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) { //不选择该种硬币
                    continue;
                }
                int pre = dp[i - coin];
                if (pre == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], pre + 1);
            }
        }
        return dp[amount];
    }


}
