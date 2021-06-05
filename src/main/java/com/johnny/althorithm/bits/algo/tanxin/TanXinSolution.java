package com.johnny.althorithm.bits.algo.tanxin;

public class TanXinSolution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farest = 0;
        for (int i = 0; i < n; i++) {
            farest = Math.max(farest, i + nums[i]);
            if (farest <= i) {
                return false;
            }
        }
        return farest >= n - 1;
    }
}
