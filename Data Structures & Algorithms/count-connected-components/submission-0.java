class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Because the graph is undirected
        }

        int count=0;
        for(int i=0; i<n; i++) {
           if(!visited[i]) {
            count++;
            dfs(adj, i, visited);
           }
        }
        return count;
    }

    public void dfs (List<List<Integer>> graph, int i, boolean []visited) {
        visited[i] = true;
        for(int node : graph.get(i)) {
            if(!visited[node]) {
                dfs(graph, node, visited);
            }
        }
    }
}
