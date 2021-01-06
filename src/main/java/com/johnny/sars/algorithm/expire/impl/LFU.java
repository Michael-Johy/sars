package com.johnny.sars.algorithm.expire.impl;

import com.johnny.sars.algorithm.expire.ExpireStrategy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LFU<T> implements ExpireStrategy<T> {
    @Override
    public T determine(List<T> data, List<T> usedData) {
        Map<T, Long> count = new TreeMap<T, Long>();
        for (T item : usedData) {

        }
        return null;
    }
}
