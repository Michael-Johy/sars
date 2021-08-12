package com.johnny.althorithm.datastruct.bst;

/**
 * n个节点的二叉树有多少种形态。 前提条件：所有节点都相同
 */
public class MaxNumSolution2 {
    public static void main(String[] args) {
        MaxNumSolution2 solution2 = new MaxNumSolution2();
        int n = 4;
        int res = solution2.maxNum(n);
        System.out.println("size = " + n + ", type = " + res);
    }

    private int[] dp;

    public int doMaxNum(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int res = 0;
        for (int i = 0; i <= n - 1; i++) { //左侧子树的形态种类
            int left = doMaxNum(i);
            int right = doMaxNum(n - 1 - i);
            res += left * right;
        }
        return res;
    }

    public int maxNum(int n) {
        dp = new int[n + 1];
        return doMaxNum(n);
    }
}
