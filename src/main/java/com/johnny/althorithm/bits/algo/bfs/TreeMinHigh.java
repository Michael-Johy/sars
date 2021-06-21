package com.johnny.althorithm.bits.algo.bfs;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMinHigh {

    public static void main(String[] args) {

    }

    private int minHigh(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            Queue<TreeNode> newQ = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (null == node || node.left == null || node.right == null) {
                    return depth;
                }
                newQ.add(node.left);
                newQ.add(node.right);
            }
            q.addAll(newQ);
            depth++;
        }
        return depth;
    }
}
