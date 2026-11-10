class Solution {
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int c = 1;
        int[] visited = new int[graph.length];
        int[] colour = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(visited[i] == 0)
                dfs(i, visited, colour, graph, c);
        }
        return res;
    }
    public void dfs(int node, int[] visited, int[] colour, int[][] graph, int c){
        visited[node] = 1;
        colour[node] = c;
        for(int i : graph[node]){
            if(visited[i] == 1 && colour[i] == c)
                res = false;
            if(visited[i] == 0)
                dfs(i, visited, colour, graph, 1 - c);
        }
        return;
    }
}