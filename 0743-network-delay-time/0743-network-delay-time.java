class Pair {
    int node;
    int dist;

    Pair(int dist, int node) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // decreasing by 1 to the every node numbering for make it easy to solve
        for(int i = 0; i < times.length; i++){
            times[i][0] = times[i][0] - 1;
            times[i][1] = times[i][1] - 1;
        }
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int source = times[i][0];
            int dest = times[i][1];
            int dist = times[i][2];
            adj.get(source).add(new int[]{dest, dist});
        }
        int[] relx = new int[n], res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) ->{
            if(a.dist != b.dist)
                return a.dist - b.dist;
            else
                return a.node - b.node;
        });
        heap.add(new Pair(0, k - 1));
        res[k - 1] = 0;
        while(!heap.isEmpty()){
            int node = heap.peek().node;
            int dist = heap.peek().dist;
            heap.poll();
            if(relx[node] == 1)
                continue;
            relx[node] = 1;
            for(int[] L : adj.get(node)){
                int p = L[0];
                int d = L[1] + dist;
                if(relx[p] != 1 && d < res[p]){
                    heap.add(new Pair(d, p));
                    res[p] = d;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : res)
            max = Math.max(i, max);
        return max != Integer.MAX_VALUE ? max : -1;
    }
}