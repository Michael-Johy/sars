package com.johnny.althorithm.bits.algo.datastruct.iterator;

import java.util.List;

public class NestedInteger {
    public Integer val;
    public List<NestedInteger> list;

    public boolean isInteger(){
        return null != val;
    }

    public NestedInteger(Integer val) {
        this.val = val;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

}
