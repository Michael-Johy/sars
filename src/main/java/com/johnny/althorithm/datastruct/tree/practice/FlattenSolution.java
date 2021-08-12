package com.johnny.althorithm.datastruct.tree.practice;

import com.johnny.althorithm.datastruct.tree.TreeNode;
import com.johnny.althorithm.datastruct.tree.traverse.TraverseSolution;

import java.util.Vector;

public class FlattenSolution {
    public static void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode last = root;
        while (last.right != null) {
            last = last.right;
        }
        last.right = tmp;

    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        flatten(t1);

        TraverseSolution traverseSolution = new TraverseSolution();
        Vector<Integer> result = traverseSolution.preTraverse(t1);
        result.forEach(System.out::print);
    }
}
