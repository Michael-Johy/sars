package com.johnny.althorithm.dp;

public class CoinTest {
    public static void main(String[] args) {
        int[] coins = new int[]{10, 5, 8, 1};
        CoinSolution solution = new CoinSolution();
        int result = solution.coinChange2(coins, 11);
        System.out.println(result);
    }
}
