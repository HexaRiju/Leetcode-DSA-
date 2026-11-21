class Pair {
    int x, y, effort;

    Pair(int x, int y, int effort) {
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] height) {
        int n = height.length, m = height[0].length;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) ->{
            return a.effort - b.effort;
        });
        int[][] res = new int[n][m], relx = new int[n][m];
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[i].length; j++){
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        heap.add(new Pair(0, 0, 0));
        res[0][0] = 0;
        while(! heap.isEmpty()){
            int x = heap.peek().x;
            int y = heap.peek().y;
            heap.poll();
            if(relx[x][y] == 1)
                continue;
            relx[x][y] = 1;
            int[] X = {1, -1, 0, 0};
            int[] Y = {0, 0, -1, 1};
            for(int p = 0; p < 4; p++){
                int a = x + X[p];
                int b = y + Y[p];
                if(valid(a, b, n, m)){
                    int currEf = Math.max((int)Math.abs(height[x][y] - height[a][b]), res[x][y]);
                    if(relx[a][b] != 1 && currEf < res[a][b]){
                        heap.add(new Pair(a, b, currEf));
                        res[a][b] = currEf;
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(res));
        return res[n - 1][m - 1];
    }

    public boolean valid(int x, int y, int n, int m) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }
}