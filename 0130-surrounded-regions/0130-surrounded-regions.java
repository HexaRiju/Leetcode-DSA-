class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) && board[i][j] == 'O')
                    dfs(i, j, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '#')
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public boolean valid(int row, int col, int n, int m) {
        return (row >= 0 && row < n) && (col >= 0 && col < m);
    }

    public void dfs(int i, int j, char[][] board) {
        board[i][j] = '#';
        int[] x = { 0, 0, -1, 1 };
        int[] y = { -1, 1, 0, 0 };
        for (int k = 0; k < 4; k++) {
            int row = i + x[k];
            int col = j + y[k];
            if (valid(row, col, board.length, board[0].length) && board[row][col] == 'O')
                dfs(row, col, board);
        }
        return;
    }
}