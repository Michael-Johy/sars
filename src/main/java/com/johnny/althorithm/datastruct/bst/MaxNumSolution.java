package com.johnny.althorithm.datastruct.bst;

/**
 * [1-n] 组成的二叉搜索树有多少种形态
 */
public class MaxNumSolution {
    public static void main(String[] args) {
        MaxNumSolution solution = new MaxNumSolution();
        System.out.println(solution.nums(3));
    }

    public int nums(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return nums(1, n, memo);
    }

    public int nums(int lo, int hi, int[][] memo) {
        if (lo > hi) {
            return 1;
        }
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = nums(lo, i - 1, memo);
            int right = nums(i + 1, hi, memo);
            res += left * right;
        }
        memo[lo][hi] = res;
        return res;
    }
}
