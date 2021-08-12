package com.johnny.althorithm.dp;

public class MyTest {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{2, 1, 3};
        matrix[1] = new int[]{6, 5, 4};
        matrix[2] = new int[]{7, 8, 9};

        MyTest myTest = new MyTest();
        System.out.println(myTest.findMin(matrix));
    }


    public int findMin(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;

        int[][] dp = new int[row][col];
        dp[0] = matrix[0];
        for (int r = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                //上左、上右、上
                if (c == 0) {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r - 1][c + 1]) + matrix[r][c];
                } else if (c == col - 1) {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r - 1][c - 1]) + matrix[r][c];
                } else {
                    dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r - 1][c - 1]), dp[r - 1][c + 1]) + matrix[r][c];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int c = 0; c < col; c++) {
            res = Math.min(dp[row - 1][c], res);
        }
        return res;
    }


}
