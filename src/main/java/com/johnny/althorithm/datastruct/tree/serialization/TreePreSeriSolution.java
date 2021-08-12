package com.johnny.althorithm.datastruct.tree.serialization;

import com.google.common.collect.Lists;
import com.johnny.althorithm.datastruct.tree.TreeNode;

import java.util.List;

/**
 *
 */
public class TreePreSeriSolution {

    public static final String JIN = "#";

    public String serialise(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            result.append(JIN);
            return result.toString();
        }
        result.append(root.value);
        result.append(serialise(root.left));
        result.append(serialise(root.right));
        return result.toString();
    }

    public TreeNode deserialise(String input) {
        char[] chars = input.toCharArray();
        List<String> strings = Lists.newArrayList();
        for (char item : chars) {
            strings.add(String.valueOf(item));
        }
        return deserialise(strings);
    }

    public TreeNode deserialise(List<String> chars) {
        String first = chars.remove(0);
        if (first.equalsIgnoreCase(JIN)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialise(chars);
        root.right = deserialise(chars);
        return root;
    }


}
