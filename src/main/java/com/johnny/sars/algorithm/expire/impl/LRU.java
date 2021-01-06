package com.johnny.sars.algorithm.expire.impl;

import com.johnny.sars.algorithm.expire.ExpireStrategy;

import java.util.List;

public class LRU<T> implements ExpireStrategy<T> {
    @Override
    public T determine(List<T> data, List<T> usedData) {
        return null;
    }
}
