package com.johnny.althorithm.backtrace;

import java.util.LinkedList;
import java.util.List;

public class QuanPaiLieSolution {
    public List<List<Integer>> get(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(nums, new LinkedList<>(), result);
        return result;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        if (nums.length == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }

        //这里是排列组合，对于没选过的元素都可以选择 且ABC 和ACB不同
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.addLast(nums[i]);
            backTrack(nums, track, result);
            track.removeLast();
        }
    }
}
