package com.johnny.althorithm.datastruct.tree.connect;


import com.johnny.althorithm.datastruct.tree.TreeNode;

//层级遍历一般使用迭代算法
public class ConnectSolution {

    /**
     * 把同层级的节点都连接起来，2种思路
     * 1) 遍历层级节点，从左到右一次连接起来， 空间复杂度 O(n)
     * 2) 把相邻的2个节点连接起来
     */
    public void connect1(TreeNode root) {
        if (null == root) {
            return;
        }
        doConnect(root.left, root.right);
    }

    private void doConnect(TreeNode left, TreeNode right) {
        if (null != left){
            left.next = right;
            doConnect(left.left, left.right);
            doConnect(left.right, right.left);
            doConnect(right.left, right.right);
        }

    }

}
