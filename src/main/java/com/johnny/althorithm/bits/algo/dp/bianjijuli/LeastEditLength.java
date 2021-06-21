package com.johnny.althorithm.bits.algo.dp.bianjijuli;

public class LeastEditLength {
    public static void main(String[] args) {
        String s1 = "rad";
        String s2 = "apple";
        LeastEditLength length = new LeastEditLength();
        int least = length.leastLength(s1, s2, s1.length() - 1, s2.length() - 1);
        System.out.println(least);
    }

    public int leastLength(String source, String target, int si, int ti) {
        if (si == -1) {
            return ti + 1;
        }
        if (ti == -1) {
            return si + 1;
        }
        if (source.charAt(si) == target.charAt(ti)) {
            return leastLength(source, target, --si, --ti);
        } else {
            return min(leastLength(source, target, si, ti - 1),
                    leastLength(source, target, si - 1, ti),
                    leastLength(source, target, --si, --ti)) + 1;
        }
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
