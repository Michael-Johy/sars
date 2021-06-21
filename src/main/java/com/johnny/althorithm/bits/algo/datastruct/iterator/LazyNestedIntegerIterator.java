package com.johnny.althorithm.bits.algo.datastruct.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LazyNestedIntegerIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> list;

    public LazyNestedIntegerIterator(List<NestedInteger> list) {
        this.list = new LinkedList<>(list);
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            NestedInteger first = list.removeFirst();
            int size = first.list.size();
            for (int i = size - 1; i >= 0; i--) {
                list.addFirst(first.list.get(i));
            }
        }
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        return list.removeFirst().val;
    }
}
