package com.johnny.java.threads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        Solution solution = new Solution();
        List<Integer> a=  solution.findMinHeightTrees(4, edges);
        System.out.println(a.size());
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1){
            result.add(0);
            return result;
        }

        int minHeight = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int height = bfs(i, edges, new HashSet<>());
            if (height < minHeight){
                minHeight = height;
                result = new ArrayList<>();
                result.add(i);
            }else if (height == minHeight){
                result.add(i);
            }
        }
        return result;
    }

    private int bfs(int i, int[][] edges, Set<Integer> visited){
        visited.add(i);
        Set<Integer> next = new HashSet<>();
        for (int index = 0; index < edges.length; index++){
            int first = edges[index][0];
            int second = edges[index][1];
            if (i == first){
                if (visited.contains(second)){
                    continue;
                }else{
                    next.add(second);
                }
            }else if(i == second){
                if (visited.contains(first)){
                    continue;
                }else{
                    next.add(first);
                }
            }
        }
        int height = 0;
        if (!next.isEmpty()){
            for (Integer item : next){
                height = Math.max(bfs(item, edges, visited), height);
            }
        }
        return height + 1;
    }


}
