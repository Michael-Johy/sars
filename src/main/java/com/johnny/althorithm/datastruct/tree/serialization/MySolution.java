package com.johnny.althorithm.datastruct.tree.serialization;

import com.johnny.althorithm.datastruct.tree.TreeNode;

public class MySolution {
    public String serialize(TreeNode root) {
        if (null == root){
            return "#";
        }
        StringBuilder result = new StringBuilder();
        result.append(root.value);
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data){
            return null;
        }
        char item = data.charAt(0);
        if (item == '#'){
            return null;
        }
        TreeNode root = new TreeNode(item - '0');
        root.left = deserialize(data.substring(1, data.length()));
        root.right = deserialize(data.substring(1, data.length()));
        return root;
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t4, t5);
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t1 = new TreeNode(1, t2, t3);
        MySolution mySolution = new MySolution();
        String data = mySolution.serialize(t1);

        TreeNode root = mySolution.deserialize(data);
        System.out.println(root);
    }
}
