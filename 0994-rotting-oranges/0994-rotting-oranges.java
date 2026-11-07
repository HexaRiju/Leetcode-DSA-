class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                    grid[i][j] = -1;
                }
                if (grid[i][j] == 1)
                    fresh++;
            }
        }
        return bfs(grid, fresh, q);
    }

    public boolean valid(int n, int m, int row, int coll) {
        return (row >= 0 && row < n) && (coll >= 0 && coll < m);
    }

    public int bfs(int[][] grid, int fresh, Queue<int[]> q) {
        int time = 0, n = grid.length, m = grid[0].length;
        int[] x = { 0, 0, -1, 1 };
        int[] y = { -1, 1, 0, 0 };
        while (!q.isEmpty() && fresh > 0) {
            time++;
            int size = q.size();
            while (size > 0) {
                int[] index = q.remove();
                for (int i = 0; i < 4; i++) {
                    int row = index[0] + x[i];
                    int coll = index[1] + y[i];
                    if (valid(n, m, row, coll) && grid[row][coll] != 0 && grid[row][coll] != -1) {
                        q.add(new int[] { row, coll });
                        grid[row][coll] = -1;
                        fresh--;
                    }
                }
                size--;
            }
        }
        if(fresh == 0)
            return time;
        return -1;
    }
}