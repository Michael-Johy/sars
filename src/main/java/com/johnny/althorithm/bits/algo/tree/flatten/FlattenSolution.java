package com.johnny.althorithm.bits.algo.tree.flatten;

import com.johnny.althorithm.bits.algo.tree.TreeNode;


/**
 * 1
 * 2       3
 * 4   5   6    7
 * <p>
 * =>   1
 * 2
 * 4
 * 5
 * 3
 * 6
 * 7
 * <p>
 * 解题思路：先把左子树扁平，再把右子树扁平、再把整个树扁平
 * 扁平就是把左子树嫁接到父节点和右子树中间
 */
public class FlattenSolution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        tmp.right = right;
    }
}
