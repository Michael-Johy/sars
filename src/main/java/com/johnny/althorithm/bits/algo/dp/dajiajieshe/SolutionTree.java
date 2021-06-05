package com.johnny.althorithm.bits.algo.dp.dajiajieshe;

public class SolutionTree {
    public int rob(int[] prices) {
        int n = prices.length;
        int level = (int) (Math.log(n + 1) / Math.log(2));
        int[] dp = new int[level + 1];
        if (level == 1) {
            return prices[0];
        }
        if (level == 2) {
            return prices[1] + prices[2];
        }
        dp[1] = prices[0];
        dp[2] = prices[1] + prices[2];


        for (int i = 3; i <= level; i++) {
            int startIndex = (int) Math.pow(2, i - 1) - 1;
            int endIndex = (int) Math.pow(2, i) - 1;
            int sumI = 0;
            for (int j = startIndex; j < endIndex; j++) {
                sumI += prices[j];
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sumI);
        }
        return dp[level];
    }


    public static void main(String[] args) {
        SolutionTree s = new SolutionTree();
        int[] prices = new int[]{3, 2, 3, 0, 3, 0, 1};
        int rob = s.rob(prices);
        System.out.println(rob);
    }
}

