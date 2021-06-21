package com.johnny.althorithm.bits.algo.datastruct.graph;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0 -> 1, 2
 * 1 -> 3
 * 2 -> 3
 * 3 -> []
 * <p>
 * 求0-3所有路径
 */
public class GraphSolution {

    private static List<List<Integer>> res = Lists.newArrayList();

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Lists.newArrayList(1, 2));
        graph.add(Lists.newArrayList(3));
        graph.add(Lists.newArrayList(3));
        graph.add(Lists.newArrayList());

        GraphSolution solution = new GraphSolution();
        solution.traverse(graph, 0, new LinkedList<>());
        System.out.println(res);
    }

    public void traverse(List<List<Integer>> graph, int start, LinkedList<Integer> path) {
        path.add(start);
        if (start == graph.size() - 1) {
            res.add(Lists.newArrayList(path));
            path.removeLast();
            return;
        }
        for (Integer neighbor : graph.get(start)) {
            traverse(graph, neighbor, path);
        }
        path.removeLast();
    }
}
