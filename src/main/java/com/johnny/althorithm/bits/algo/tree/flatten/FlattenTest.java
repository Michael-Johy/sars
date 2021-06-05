package com.johnny.althorithm.bits.algo.tree.flatten;

import com.johnny.althorithm.bits.algo.tree.TreeNode;

public class FlattenTest {
    public static void main(String[] args) {
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        FlattenSolution solution = new FlattenSolution();
        solution.flatten(t1);
        System.out.println(t1);


    }
}
