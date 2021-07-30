package com.johnny.althorithm.bits;

import com.johnny.althorithm.bits.algo.datastruct.tree.TreeNode;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();


        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t5 = new TreeNode(5, t2, t3);
        int[] nums = solution.findFrequentTreeSum(t5);
        System.out.println(nums.length);
//        solution.lowestCommonAncestor(t3, t5, t4);
//        System.out.println(solution.sumOfLeftLeaves(t));
//        System.out.println(solution.deleteNode(t5, 3));
    }

    public Map<Integer, Integer> eleToCnt = new HashMap<>();
    public Map<Integer, Set<Integer>> cntToEles = new HashMap<>();
    public int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        Set<Integer> eles = cntToEles.get(maxCount);
        int[] result = new int[eles.size()];

        List<Integer> eleList = new ArrayList<>(eles);

        for (int i=0;i<eles.size();i++){
            result[i] = eleList.get(i);
        }
        return result;
    }

    public int dfs(TreeNode root){
        if (null == root){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = left + right + root.value;
        update(sum);
        return sum;
    }

    public void update(int ele){
        int count = eleToCnt.getOrDefault(ele, 0);

        if (cntToEles.containsKey(count)){
            cntToEles.get(count).remove(ele);
        }

        int newCount = count + 1;
        eleToCnt.put(ele, newCount);
        if (cntToEles.containsKey(newCount)){
            cntToEles.get(newCount).add(ele);
        }else{
            Set<Integer> tmp = new HashSet<>();

            cntToEles.put(newCount, new HashSet<>(ele));
        }
        if (newCount > maxCount){
            maxCount = newCount;
        }
    }
}
