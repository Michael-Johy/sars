package com.johnny.althorithm.backtrace;

import java.util.List;

public class BackTrackTest {
    public static void main1(String[] args) {
        QuanPaiLieSolution solution = new QuanPaiLieSolution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = solution.get(nums);
        for (List<Integer> item : result) {
            for (Integer i : item) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        SumTarget solution = new SumTarget();
        int result = solution.getTargetNum(nums, 3);
        System.out.println(result);
    }
}
