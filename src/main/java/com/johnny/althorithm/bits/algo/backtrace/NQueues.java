package com.johnny.althorithm.bits.algo.backtrace;

public class NQueues {

    public int[][] solve(int n) {
        int[][] result = new int[n][n];
        backTrack(result, 0, n);
        return result;
    }

    public void backTrack(int[][] result, int columnIndex, int totalN) {
        if (columnIndex == totalN) {
            return;
        }
        for (int i = 0; i < totalN; i++) { //行数
            if (!isValid(i, columnIndex, result)) {
                continue;
            }
            result[i][columnIndex] = 1;
            backTrack(result, ++columnIndex, totalN);
            result[i][columnIndex] = 0;
        }
    }

    private boolean isValid(int rowIndex, int columnIndex, int[][] result) {
        //check row
        for (int i = 0; i < columnIndex; i++) {
            if (result[rowIndex][columnIndex] == 1) {
                return false;
            }
        }
        //check column
        //true

        //check left-top & left-botton
        if (result[--rowIndex][--columnIndex] == 1 || result[++rowIndex][--columnIndex] == 1) {
            return false;
        }
        return true;
    }

}
