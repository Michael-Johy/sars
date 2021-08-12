package com.johnny.althorithm.datastruct.tree.buildTree;

import com.johnny.althorithm.datastruct.tree.TreeNode;

import java.util.Arrays;

/**
 * 给定一个数组，找出最大值作为根节点
 * 根节点左边的数据作为左子树
 * 根节点右边的数据作为右子树
 */
public class BuildTreeSolution {

    public TreeNode buildTree(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        int index = 0;
        int max = nums[index];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildTree(Arrays.copyOfRange(nums, 0, index));
        root.right = buildTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        BuildTreeSolution buildTreeSolution = new BuildTreeSolution();
        TreeNode root = buildTreeSolution.buildTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(root.value);
    }

}
