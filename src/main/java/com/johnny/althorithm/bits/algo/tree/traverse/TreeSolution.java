package com.johnny.althorithm.bits.algo.tree.traverse;

import com.johnny.althorithm.bits.algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TreeSolution {

    public Vector<Integer> preTraverse(TreeNode root) {
        Vector<Integer> result = new Vector<>();
        if (null == root) {
            return result;
        }
        result.add(root.value);
        result.addAll(preTraverse(root.left));
        result.addAll(preTraverse(root.right));
        return result;
    }

    public Vector<Integer> postTraverse(TreeNode root) {
        Vector<Integer> result = new Vector<>();
        if (null == root) {
            return result;
        }
        result.addAll(postTraverse(root.left));
        result.addAll(postTraverse(root.right));
        result.add(root.value);
        return result;
    }

    public Vector<Integer> inTraverse(TreeNode root) {
        Vector<Integer> result = new Vector<>();
        if (null == root) {
            return result;
        }
        result.addAll(inTraverse(root.left));
        result.add(root.value);
        result.addAll(inTraverse(root.right));
        return result;
    }

    public Vector<Integer> levelTraverse(TreeNode root) {
        Vector<Integer> result = new Vector<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode item = queue.poll();
            result.add(item.value);

            if (null != item.left) {
                queue.offer(item.left);
            }
            if (null != item.right) {
                queue.offer(item.right);
            }
        }
        return result;
    }

}
