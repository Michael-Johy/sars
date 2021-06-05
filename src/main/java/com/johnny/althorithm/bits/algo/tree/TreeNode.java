package com.johnny.althorithm.bits.algo.tree;

/**
 * 递归算法：明确函数定义是什么、相信定义、根据定义进行推导、验证
 * <p>
 * 树的递归算法：明确根节点应该做什么，同理子节点需要做什么，遍历下去
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
