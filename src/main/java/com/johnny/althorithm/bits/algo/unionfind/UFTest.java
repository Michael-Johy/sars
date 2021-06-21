package com.johnny.althorithm.bits.algo.unionfind;

public class UFTest {
    public static void main(String[] args) {
        UF uf = new UF(5);
        uf.union(1, 2);
        uf.union(1, 3);
        boolean connected = uf.connected(1, 2);
        int count = uf.getCount();
        System.out.println(connected);
        System.out.println(count);
    }
}
