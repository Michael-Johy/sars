package com.johnny.althorithm.bits.algo.datastruct.tree.nodes;


import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

public class NodesTest {
    public static void main1(String[] args) {
        NodesSolution solution = new NodesSolution();
//        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        int nums = solution.nodeNums(t1);
        System.out.println("nums = " + nums);
    }

    public static void main(String[] args) {
        NodesSolution solution = new NodesSolution();
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        int nums = solution.maxLength(t1);
        System.out.println("nums = " + nums);
    }
}
