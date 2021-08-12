package com.johnny.althorithm;

class Solution {

    public static void main(String[] args) {
        char[][] board = new char[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                board[i][j] = 'O';
            }
        }
        Solution solution = new Solution();
        solution.solve(board);
        System.out.println(board);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }

        for (int i = 1; i < n - 1; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m - 1, i, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void dfs(char[][] board, int x, int y, int row, int col) {
        if (x >= row || x < 0 || y < 0 || y >= col || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y, row, col);
        dfs(board, x - 1, y, row, col);
        dfs(board, x, y + 1, row, col);
        dfs(board, x, y - 1, row, col);
    }
}
