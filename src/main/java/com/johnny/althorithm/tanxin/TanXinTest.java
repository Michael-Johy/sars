package com.johnny.althorithm.tanxin;

public class TanXinTest {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 0, 0, 4};
        TanXinSolution solution = new TanXinSolution();
        boolean canJump = solution.canJump(nums);
        System.out.println(canJump);

    }
}
