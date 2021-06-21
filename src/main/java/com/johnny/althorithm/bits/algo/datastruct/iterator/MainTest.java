package com.johnny.althorithm.bits.algo.datastruct.iterator;

import com.google.common.collect.Lists;

import java.util.List;

public class MainTest {

    public static void main1(String[] args) {
        NestedInteger a1 = new NestedInteger(1);
        NestedInteger a2 = new NestedInteger(2);
        NestedInteger a3 = new NestedInteger(3);
        NestedInteger a4 = new NestedInteger(4);
        NestedInteger a5 = new NestedInteger(5);
        NestedInteger a6 = new NestedInteger(6);

        List<NestedInteger> list = Lists.newArrayList(a1,
                new NestedInteger(Lists.newArrayList(a2, a3, a4)),
                new NestedInteger(Lists.newArrayList(a5, a6)));

        NestedIntegerIterator iterator = new NestedIntegerIterator(list);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        NestedInteger a1 = new NestedInteger(1);
        NestedInteger a2 = new NestedInteger(2);
        NestedInteger a3 = new NestedInteger(3);
        NestedInteger a4 = new NestedInteger(4);
        NestedInteger a5 = new NestedInteger(5);
        NestedInteger a6 = new NestedInteger(6);

        List<NestedInteger> list = Lists.newArrayList(a1,
                new NestedInteger(Lists.newArrayList(a2, a3, a4)),
                new NestedInteger(Lists.newArrayList(a5, a6)));
        LazyNestedIntegerIterator iterator = new LazyNestedIntegerIterator(list);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
