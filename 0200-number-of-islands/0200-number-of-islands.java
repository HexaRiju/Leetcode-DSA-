class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(i, j, n, m, visited, grid);
                    res++;
                }
            }
        }
        return res;
    }
    public boolean valid(int row, int col, int n, int m){
        if((row < 0 || row >= n)  || (col < 0 || col >= m))
            return false;
        return true;
    }
    public void dfs(int i, int j, int n, int m, int[][] visited, char[][] grid) {
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        visited[i][j] = 1;
        for(int k = 0; k < 4; k++){
            int row = i + x[k];
            int col = j + y[k];
            if(valid(row, col, n, m) && visited[row][col] == 0 && grid[row][col] == '1')
                dfs(row, col, n, m, visited, grid);
        }
        return;
    }
}