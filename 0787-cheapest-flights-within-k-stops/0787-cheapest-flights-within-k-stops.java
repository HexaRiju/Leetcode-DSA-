class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res = new int[n], temp = new int[n];
        int INF = 100000;
        Arrays.fill(res, INF);
        Arrays.fill(temp, INF);
        res[src] = 0;
        temp[src] = 0;
        for (int i = 0; i <= k; i++) {
            for (int[] j : flights) {
                int s = j[0];
                int d = j[1];
                int w = j[2];
                if (res[s] != INF && temp[d] > res[s] + w)
                    temp[d] = res[s] + w;
            }
            for(int j = 0; j < res.length; j++)
                res[j] = temp[j];
        }
        if (res[dst] == INF)
            return -1;
        return res[dst];
    }
}