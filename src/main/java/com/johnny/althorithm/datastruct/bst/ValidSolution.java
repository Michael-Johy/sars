package com.johnny.althorithm.datastruct.bst;

import com.johnny.althorithm.datastruct.tree.TreeNode;

public class ValidSolution {
    public static void main(String[] args) {
        TreeNode t6 = new TreeNode(6);
        TreeNode t20 = new TreeNode(20);
        TreeNode t5 = new TreeNode(5);
        TreeNode t15 = new TreeNode(15, t6, t20);
        TreeNode t10 = new TreeNode(10, t5, t15);

        ValidSolution solution = new ValidSolution();
        boolean valid = solution.isValidBST(t10, null, null);
        System.out.println(valid);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) {
            return true;
        }
        if (null != min && root.value < min.value) {
            return false;
        }
        if (null != max && root.value > max.value) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
