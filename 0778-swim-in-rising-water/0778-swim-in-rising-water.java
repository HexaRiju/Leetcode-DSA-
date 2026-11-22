class Solution {
    boolean find = false;
    public int swimInWater(int[][] grid) {
        int start = 2500, end = 0;
        for(int[] i : grid){
            for(int j : i){
                start = Math.min(start, j);
                end = Math.max(end, j);
            }
        }
        int res = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            dfs(mid, grid, 0, 0, new int[grid.length][grid[0].length]);
            if(find){
                end = mid - 1;
                res = mid;
                find = false;
            }
            else{
                start = mid + 1;
            }
        }
        return res;
    }
    public boolean valid(int n, int m, int a, int b){
        return a >= 0 && a < n && b >= 0 && b < m;
    }
    public void dfs(int amount, int[][] grid, int x, int y, int[][] visited){
        if(grid[x][y] > amount){
            return ;
        }
        int n = grid.length;
        int m = grid[0].length;
        if(x == n - 1 && y == m - 1)
            find = true;
        int[] X = {1, -1, 0, 0};
        int[] Y = {0, 0, -1, 1};
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++){
            int a = x + X[i];
            int b = y + Y[i];
            if(valid(n, m, a, b) && visited[a][b] != 1)
                dfs(amount, grid, a, b, visited);
        }
        return;
    } 
}