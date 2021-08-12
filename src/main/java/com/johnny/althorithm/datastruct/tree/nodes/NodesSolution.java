package com.johnny.althorithm.datastruct.tree.nodes;


import com.johnny.althorithm.datastruct.tree.TreeNode;

public class NodesSolution {

    //数中节点个数 = 左子树 + 右子树 + 1
    public int nodeNums(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = nodeNums(root.left);
        int right = nodeNums(root.right);
        return left + right + 1;
    }

    //maxLength = 1 + max(left, right)
    public int maxLength(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxLength(root.left);
        int right = maxLength(root.right);
        int result = Math.max(left, right);
        return result + 1;
    }

}
