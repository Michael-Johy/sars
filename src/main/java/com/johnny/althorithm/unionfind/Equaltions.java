package com.johnny.althorithm.unionfind;

import com.google.common.collect.Lists;

import java.util.List;

public class Equaltions {

    public static void main(String[] args) {
        List<String> equals = Lists.newArrayList("a==b", "a!=c", "b==c");
        Equaltions equaltions = new Equaltions();
        System.out.println(equaltions.equals(equals));
    }

    public boolean equals(List<String> equals) {
        UF uf = new UF(26);
        for (String item : equals) {
            if (item.charAt(1) == '=') {
                uf.union(item.charAt(0) - 'a', item.charAt(3) - 'a');
            }
        }
        for (String item : equals) {
            if (item.charAt(1) == '!') {
                if (uf.connected(item.charAt(0) - 'a', item.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
