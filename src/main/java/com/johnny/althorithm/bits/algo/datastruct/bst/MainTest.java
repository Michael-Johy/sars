package com.johnny.althorithm.bits.algo.datastruct.bst;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

public class MainTest {
    public static void main(String[] args) {
        TreeNode root = null;
        MainTest mainTest = new MainTest();
        mainTest.init(root);
        System.out.println(root);
    }

    private void init(TreeNode a){
        a = new TreeNode(1);
    }
}
