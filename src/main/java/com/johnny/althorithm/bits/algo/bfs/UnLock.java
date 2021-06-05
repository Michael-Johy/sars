package com.johnny.althorithm.bits.algo.bfs;

import com.google.common.collect.Sets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class UnLock {

    public int resolve(String start, Set<String> deadLocks, String end) {
        Queue<String> q = new LinkedList<>();
        q.add(start);
        Set<String> visited = Sets.newHashSet();
        visited.add(start);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String item = q.poll();
                if (end.equalsIgnoreCase(item)) {
                    return steps;
                }
                if (null == item) {
                    return steps;
                }
                for (int j = 0; j < 4; j++) {
                    String plusItem = plus(item, 0);
                    String minusItem = minus(item, 0);
                    if (!deadLocks.contains(plusItem) && !visited.contains(plusItem)) {
                        visited.add(plusItem);
                        q.add(plusItem);
                    }
                    if (!deadLocks.contains(minusItem) && !visited.contains(minusItem)) {
                        visited.add(minusItem);
                        q.add(minusItem);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public String plus(String item, int j) {
        char[] chars = item.toCharArray();
        int a = chars[j];
        chars[j] = (char) (a + 1);
        return new String(chars);
    }

    public String minus(String item, int j) {
        char[] chars = item.toCharArray();
        int a = chars[j];
        chars[j] = (char) (a - 1);
        return new String(chars);
    }

}
