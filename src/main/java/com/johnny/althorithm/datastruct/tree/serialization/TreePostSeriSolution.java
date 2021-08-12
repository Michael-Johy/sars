package com.johnny.althorithm.datastruct.tree.serialization;

import com.johnny.althorithm.datastruct.tree.TreeNode;

import java.util.LinkedList;

public class TreePostSeriSolution {

    public static final String JIN = "#";

    public String serialise(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (null == root) {
            result.append(JIN);
            return result.toString();
        }
        result.append(serialise(root.left));
        result.append(serialise(root.right));
        result.append(root.value);
        return result.toString();
    }

    public TreeNode deSerialise(String s) {
        char[] chars = s.toCharArray();
        LinkedList<String> strings = new LinkedList<>();
        for (char item : chars) {
            strings.add(String.valueOf(item));
        }
        return deSerialise(strings);
    }

    public TreeNode deSerialise(LinkedList<String> strings) {
        String rv = strings.removeLast();
        if (JIN.equals(rv)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rv));
        root.right = deSerialise(strings);
        root.left = deSerialise(strings);
        return root;
    }

}
