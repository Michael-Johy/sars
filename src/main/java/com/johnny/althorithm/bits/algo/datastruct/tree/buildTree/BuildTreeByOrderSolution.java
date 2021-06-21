package com.johnny.althorithm.bits.algo.datastruct.tree.buildTree;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

import java.util.Arrays;

public class BuildTreeByOrderSolution {

    public TreeNode preAndOrder(int[] pres, int[] ins) {
        if (ins.length == 0) {
            return null;
        }
        int rootVal = pres[0];
        TreeNode root = new TreeNode(rootVal);

        int index = -1;
        for (int i = 0; i < ins.length; i++) {
            if (ins[i] == rootVal) {
                index = i;
                break;
            }
        }
        int[] lIns = Arrays.copyOfRange(ins, 0, index);
        int[] rIns = Arrays.copyOfRange(ins, index + 1, ins.length);

        root.left = preAndOrder(Arrays.copyOfRange(pres, 1, lIns.length + 1), lIns);
        root.right = preAndOrder(Arrays.copyOfRange(pres, lIns.length + 1, pres.length), rIns);
        return root;
    }

    public TreeNode postAndOrder(int[] posts, int[] ins) {
        if (posts.length == 0) {
            return null;
        }
        int rootVal = posts[posts.length - 1];
        TreeNode root = new TreeNode(rootVal);

        int index = -1;
        for (int i = 0; i < ins.length; i++) {
            if (ins[i] == rootVal) {
                index = i;
                break;
            }
        }
        int[] lins = Arrays.copyOfRange(ins, 0, index);
        int[] rins = Arrays.copyOfRange(ins, index + 1, ins.length);

        int[] lposts = Arrays.copyOfRange(posts, 0, lins.length);
        int[] rposts = Arrays.copyOfRange(posts, lins.length, lins.length + rins.length);

        root.left = postAndOrder(lposts, lins);
        root.right = postAndOrder(rposts, rins);

        return root;
    }

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        int[] pres = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] ins = new int[]{4, 2, 5, 1, 6, 3, 7};
        int[] posts = new int[]{4, 5, 2, 6, 7, 3, 1};

        BuildTreeByOrderSolution solution = new BuildTreeByOrderSolution();
        TreeNode root = solution.preAndOrder(pres, ins);
        System.out.println(root);

        TreeNode root1 = solution.postAndOrder(posts, ins);
        System.out.println(root1);
    }

}
