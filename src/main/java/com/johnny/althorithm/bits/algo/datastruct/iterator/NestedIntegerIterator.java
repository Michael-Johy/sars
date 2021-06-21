package com.johnny.althorithm.bits.algo.datastruct.iterator;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NestedIntegerIterator implements Iterator<Integer> {

    private ListIterator<Integer> it;

    public NestedIntegerIterator(List<NestedInteger> nestedInteger) {
        List<Integer> elements = Lists.newArrayList();
        for (NestedInteger a : nestedInteger) {
            traverse(a, elements);
        }
        it = elements.listIterator();
    }

    private void traverse(NestedInteger item, List<Integer> elems) {
        if (item.isInteger()) {
            elems.add(item.val);
            return;
        }
        for (NestedInteger a : item.list) {
            traverse(a, elems);
        }
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }
}
