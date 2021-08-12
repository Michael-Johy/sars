package com.johnny.althorithm.unionfind;

public class UF {

    private int[] parents;
    private int count;
    private int[] size;

    public UF(int n) {
        parents = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
        this.count = n;
    }

    public boolean connected(int p, int q) {
        int rootQ = findRoot(q);
        int rootP = findRoot(p);
        return rootP == rootQ;
    }

    public void union(int p, int q) {
        int rootQ = findRoot(q);
        int rootP = findRoot(p);
        if (rootQ == rootP) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] = size[rootP] + size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] = size[rootP] + size[rootQ];
        }
        count--;
    }

    public int findRoot(int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    public int getCount(){
        return count;
    }
}
