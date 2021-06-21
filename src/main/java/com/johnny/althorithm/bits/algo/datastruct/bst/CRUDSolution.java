package com.johnny.althorithm.bits.algo.datastruct.bst;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

public class CRUDSolution {

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2, t1, null);

        TreeNode t6 = new TreeNode(6, t5, t7);
        TreeNode t3 = new TreeNode(3, t2, null);
        TreeNode t4 = new TreeNode(4, t3, t6);

        CRUDSolution solution = new CRUDSolution();
        boolean exist = solution.exists(t4, 8);
        System.out.println(exist);

//        TreeNode root = solution.insert(t4, 8);
//        System.out.println(root);

        TreeNode root = solution.remove(t4, 4);
        System.out.println(root);
    }

    /**
     * 搜索一个元素
     */
    public boolean exists(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.value == target) {
            return true;
        }
        if (root.value > target) {
            return exists(root.left, target);
        } else {
            return exists(root.right, target);
        }
    }

    /**
     * 插入一个元素
     */
    public TreeNode insert(TreeNode root, int target) {
        if (null == root) {
            return new TreeNode(target);
        }
        if (root.value > target) {
            root.left = insert(root.left, target);
        } else {
            root.right = insert(root.right, target);
        }
        return root;
    }


    public TreeNode remove(TreeNode root, int target) {
        if (null == root) {
            return null;
        }
        if (root.value == target) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //找到左子树最大的元素
                TreeNode maxNode = maxNode(root.left);
                root.value = maxNode.value;
                root.left = remove(root.left, maxNode.value);
            }
        } else if (root.value > target) {
            root.left = remove(root.left, target);
        } else {
            root.right = remove(root.right, target);
        }
        return root;
    }

    public TreeNode maxNode(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return maxNode(node.right);
    }
}
