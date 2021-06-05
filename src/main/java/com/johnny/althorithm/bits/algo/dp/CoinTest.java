package com.johnny.althorithm.bits.algo.dp;

public class CoinTest {
    public static void main(String[] args) {
        int[] coins = new int[]{4, 5, 8, 10};
        CoinSolution solution = new CoinSolution();
        int result = solution.coinChange2(coins, 11);
        System.out.println(result);
    }
}
