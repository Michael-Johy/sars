package com.johnny.althorithm.bits.algo.datastruct.tree.serialization;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

public class SerializationTest {
    public static void main(String[] args) {
        TreePreSeriSolution solution = new TreePreSeriSolution();
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        String result = solution.serialise(t1);
        System.out.println("result = " + result);

        TreeNode t11 = solution.deserialise(result);
        System.out.println(t11);
    }


    public static void main2(String[] args) {
        TreePostSeriSolution solution = new TreePostSeriSolution();
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        String text = solution.serialise(t1);
        System.out.println(text);
        TreeNode t11 = solution.deSerialise(text);
        System.out.println(t11);
    }

    public static void main3(String[] args) {
        TreeLevelSeriSolution solution = new TreeLevelSeriSolution();
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        String text = solution.serialise(t1);
        System.out.println(text);

        TreeNode t11 = solution.deserialise(text);
        System.out.println(t11);
    }


}
