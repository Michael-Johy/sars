package com.johnny.althorithm.bits.algo.tree.serialization;

import com.google.common.collect.Lists;
import com.johnny.althorithm.bits.algo.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelSeriSolution {

    public static final String JIN = "#";

    public String serialise(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode item = queue.poll();
            if (null != item) {
                result.append(item.value);
                queue.offer(item.left);
                queue.offer(item.right);
            } else {
                result.append(JIN);
            }
        }
        return result.toString();
    }

    public TreeNode deserialise(String s) {
        char[] chars = s.toCharArray();
        List<String> strings = Lists.newArrayList();
        for (char c : chars) {
            strings.add(String.valueOf(c));
        }
        return deserialise(strings);
    }

    public TreeNode deserialise(List<String> strings) {
        String first = strings.remove(0);
        if (JIN.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!strings.isEmpty()) {
            List<TreeNode> next = Lists.newArrayList();
            while (!queue.isEmpty()) {
                TreeNode item = queue.poll();

                String l = strings.remove(0);
                if (!JIN.equals(l)) {
                    item.left = new TreeNode(Integer.parseInt(l));
                    next.add(item.left);
                }
                String r = strings.remove(0);
                if (!JIN.equals(r)) {
                    item.right = new TreeNode(Integer.parseInt(r));
                    next.add(item.right);
                }
            }
            queue.addAll(next);
        }
        return root;
    }
}
