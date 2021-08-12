package com.johnny.althorithm.datastruct.bst;

import com.johnny.althorithm.datastruct.tree.TreeNode;

import java.util.Vector;

public class KSmallestSolution {

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, null);

        TreeNode t6 = new TreeNode(6, t5, t7);
        TreeNode t3 = new TreeNode(3, t2, null);
        TreeNode t4 = new TreeNode(4, t3, t6);

        KSmallestSolution solution = new KSmallestSolution();
        int result = solution.solve(t4, 6);
        System.out.println(result);
    }

    public int solve(TreeNode root, int k) {
        Vector<Integer> nums = new Vector<>();
        traverse(root, nums);
        if (k > nums.size()) {
            return -1;
        }
        return nums.get(k - 1);
    }

    private void traverse(TreeNode root, Vector<Integer> nums) {
        if (root == null) {
            return;
        }
        traverse(root.left, nums);
        nums.add(root.value);
        traverse(root.right, nums);
    }

}
