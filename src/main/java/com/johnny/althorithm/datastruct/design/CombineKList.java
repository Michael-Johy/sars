package com.johnny.althorithm.datastruct.design;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CombineKList {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(4);
        list1.addLast(7);
        list1.addLast(10);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addLast(2);
        list2.addLast(5);
        list2.addLast(8);
        list2.addLast(11);

        LinkedList<Integer> list3 = new LinkedList<>();
        list3.addLast(3);
        list3.addLast(6);
        list3.addLast(9);
        list3.addLast(12);

        List<LinkedList<Integer>> lists = Lists.newArrayList(list1, list2, list3);

        CombineKList combineKList = new CombineKList();
        LinkedList<Integer> list = combineKList.findTop5(lists);
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    public LinkedList<Integer> findTop5(List<LinkedList<Integer>> lists) {
        PriorityQueue<LinkedList<Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.isEmpty()) {
                return -1;
            }
            if (o2.isEmpty()) {
                return 1;
            }
            return o2.getLast() - o1.getLast();
        });
        queue.addAll(lists);
        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            if (result.size() == 5) {
                return result;
            }
            LinkedList<Integer> item = queue.poll();
            result.addLast(item.removeLast());
            if (!item.isEmpty()) {
                queue.add(item);
            }
        }
        return result;
    }


}
