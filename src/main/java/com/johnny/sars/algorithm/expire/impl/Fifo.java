package com.johnny.sars.algorithm.expire.impl;

import com.johnny.sars.algorithm.expire.ExpireStrategy;

import java.util.List;

public class Fifo<T1> implements ExpireStrategy<T1> {

    @Override
    public T1 determine(List<T1> data, List<T1> usedData) {
        return data.get(0);
    }
}
