class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i< n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if(!dfs(0, -1, visit, adj)) {
            return false;
        }

        return (visit.size() == n);
    }

    public boolean dfs(int curr, int parent, Set<Integer> visit,
    List<List<Integer>> adj) {
        if(visit.contains(curr)) {
            return false;
        }

        visit.add(curr);
        for(int nei : adj.get(curr)) {
            if(nei == parent) {
                continue;
            }
            if(!dfs(nei, curr, visit, adj)) {
                return false;
            }
        }
        return true;
        
    }
}
