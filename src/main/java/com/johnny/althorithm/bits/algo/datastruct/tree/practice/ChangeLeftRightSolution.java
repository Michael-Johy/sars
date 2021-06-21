package com.johnny.althorithm.bits.algo.datastruct.tree.practice;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;
import com.johnny.althorithm.bits.algo.datastruct.tree.traverse.TraverseSolution;

import java.util.Vector;

/**
 * 左右子树交换
 */
public class ChangeLeftRightSolution {

    public static void change(TreeNode root) {
        if (null != root.left) {
            change(root.left);
        }
        if (null != root.right) {
            change(root.right);
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        TraverseSolution traverseSolution = new TraverseSolution();

        Vector<Integer> pre = traverseSolution.preTraverse(t1);
        pre.forEach(System.out::print);
        change(t1);
        System.out.println("===");
        Vector<Integer> pre1 = traverseSolution.preTraverse(t1);
        pre1.forEach(System.out::print);
    }
}
