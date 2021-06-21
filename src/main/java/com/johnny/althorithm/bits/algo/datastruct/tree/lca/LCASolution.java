package com.johnny.althorithm.bits.algo.datastruct.tree.lca;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

/**
 * 最先公共祖先：
 * 情况1:如果p和q都在以root为根的树中，则left和right一定分别是p和q
 * 情况2:如果p和q都不在以root为根的树中，则left和right都等于null
 * 情况3:如果其中一个在，则返回left or right
 */
public class LCASolution {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t8 = new TreeNode(8);

        TreeNode t7 = new TreeNode(7, null, t8);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, null);
        TreeNode root = new TreeNode(1, t2, t3);

        LCASolution solution = new LCASolution();
        TreeNode result = solution.findLCA(root, t6, t8);
        System.out.println(result.value);
    }

    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root == q || root == p) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}
