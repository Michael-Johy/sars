package com.johnny.sars.algorithm.expire;

import java.util.List;

public interface ExpireStrategy<T> {

    int CACHE_SIZE = 10;

    T determine(List<T> data, List<T> usedData);
}
