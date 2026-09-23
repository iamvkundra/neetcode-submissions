class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        solve(board, 0);
        return result;
    }

    private void solve(int[][] board, int row) {
        if (row >= board.length) {
            result++;
            return;
        }

        for (int i=0; i<board.length; i++) {
            if (valid(board, row, i)) {
                board[row][i] = 1;
                solve(board, row+1);
                board[row][i] = 0;
            }
        }
    }

    private boolean valid(int[][] board, int i, int j) {
        for (int index=0; index<board.length; index++) {
            if (board[index][j] == 1) {
                return false;
            }
        }

        for (int iI = i-1, jJ=j-1; iI>=0 && jJ>=0; iI--, jJ--) {
            if (board[iI][jJ] == 1)  {
                return false;
            }
        }

        for (int iI = i-1, jJ=j+1; iI>=0 && jJ < board.length; iI--, jJ++) {
            if (board[iI][jJ] == 1)  {
                return false;
            }
        }
        return true;
    }
}