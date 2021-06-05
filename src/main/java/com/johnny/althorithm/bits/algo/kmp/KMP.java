package com.johnny.althorithm.bits.algo.kmp;

public class KMP {

    public int dp[][];
    public String pat;

    public KMP(String pat) {
        this.pat = pat;
    }

    public void buildDp() {
        int M = pat.length();
        //dp[状态][字符] = 下个状态
        dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 256; j++) {
                if (pat.charAt(i) == j) {
                    dp[i][j] = ++i;
                } else {
                    dp[i][j] = dp[X][j];
                }
            }
            X = dp[X][pat.charAt(i)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int j = 0;
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            j = dp[j][c];
            if (j == M) {
                return i - M + 1;
            }
        }
        return -1;
    }

}
