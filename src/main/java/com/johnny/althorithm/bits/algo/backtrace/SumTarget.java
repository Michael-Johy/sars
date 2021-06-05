package com.johnny.althorithm.bits.algo.backtrace;

import java.util.Arrays;
import java.util.LinkedList;

public class SumTarget {

    public static int result = 0;

    public int getTargetNum(int[] nums, int target) {
        backTrace(nums, target, new LinkedList<>());
        return result;
    }

    private void backTrace(int[] nums, int target, LinkedList<Integer> track) {
        if (track.size() == 5) {
            int sum = 0;
            for (Integer item : track) {
                sum += item;
            }
            if (target == sum) {
                result++;
                for (Integer item : track) {
                    System.out.print(item);
                }
                System.out.println();
            }
            return;
        }

        int[] newNums = Arrays.copyOfRange(nums, 1, nums.length);

        //这里是求和，我们要定义好顺序
        track.addLast(nums[0]);
        backTrace(newNums, target, track);
        track.removeLast();

        track.addLast(-nums[0]);
        backTrace(newNums, target, track);
        track.removeLast();

    }

}
