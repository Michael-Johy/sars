package com.johnny.althorithm.bits.algo.tree.traverse;

import com.johnny.althorithm.bits.algo.tree.TreeNode;

import java.util.Vector;

public class TraverseTest {
    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        Vector<Integer> pre = solution.preTraverse(t1);
        System.out.print("pre = ");
        for (Integer item : pre) {
            System.out.print(item + ", ");
        }

        System.out.println("");
        Vector<Integer> post = solution.postTraverse(t1);
        System.out.print("post = ");
        for (Integer item : post) {
            System.out.print(item + ", ");
        }

        System.out.println("");
        Vector<Integer> in = solution.inTraverse(t1);
        System.out.print("in = ");
        for (Integer item : in) {
            System.out.print(item + ", ");
        }
        System.out.println("");
        Vector<Integer> level = solution.levelTraverse(t1);
        System.out.print("level = ");
        for (Integer item : level) {
            System.out.print(item + ", ");
        }

    }
}
