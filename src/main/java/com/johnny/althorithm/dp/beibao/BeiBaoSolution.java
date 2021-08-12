package com.johnny.althorithm.dp.beibao;

/**
 * 经典动态规划：0-1背包问题
 * designpattern[i][w] 表示当可选择物品个数为i个时，背包重量为w时的最大价值
 */
public class BeiBaoSolution {

    public static int maxValue(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < weights[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{2, 1, 3};
        int[] values = new int[]{4, 2, 4};
        int maxValue = maxValue(4, 3, weights, values);
        System.out.println(maxValue);
    }


}
