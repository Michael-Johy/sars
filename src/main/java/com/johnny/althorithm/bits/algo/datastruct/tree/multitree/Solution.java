package com.johnny.althorithm.bits.algo.datastruct.tree.multitree;

public class Solution {

    public static void main(String[] args) {
        MultiTreeNode m5 = new MultiTreeNode(5, null);
        MultiTreeNode m6 = new MultiTreeNode(6, null);
        MultiTreeNode m7 = new MultiTreeNode(7, null);
        MultiTreeNode m8 = new MultiTreeNode(8, null);
        MultiTreeNode m9 = new MultiTreeNode(9, null);
        MultiTreeNode m10 = new MultiTreeNode(10, null);

        MultiTreeNode m2 = new MultiTreeNode(2, new MultiTreeNode[]{m5, m6});
        MultiTreeNode m3 = new MultiTreeNode(3, new MultiTreeNode[]{m7, m8});
        MultiTreeNode m4 = new MultiTreeNode(4, new MultiTreeNode[]{m9, m10});
        MultiTreeNode m1 = new MultiTreeNode(1, new MultiTreeNode[]{m2, m3, m4});

        Solution solution = new Solution();
        solution.traverse(m1);

    }

    public void traverse(MultiTreeNode m1) {
        if (null == m1) {
            return;
        }
        System.out.println(m1.val);
        if (m1.childs != null){
            for (MultiTreeNode node : m1.childs) {
                traverse(node);
            }
        }
    }

}
