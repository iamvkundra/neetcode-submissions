class Solution {

    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '%') {
            return;
        }

        board[i][j] = '%';
        for (int[] direction : directions) {
            dfs(board, i + direction[0], j + direction[1]);
        }
    }
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                dfs(board, board.length - 1, j);
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '%') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
