class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) { 
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();

        for(int i =0; i<n; i++) {
            if(hasCycle(i, i, visited, currentPath, adj)) return false;
        }

        return visited.size() == n;
    }

    private boolean hasCycle(int node, int parent, Set<Integer> visited, Set<Integer> currentPath, List<List<Integer>> adj) {
        if(visited.contains(node)) return false;
        if(currentPath.contains(node)) return true;

        currentPath.add(node);

        for(int n : adj.get(node)) {
            if(n == parent) continue;
            if(hasCycle(n, node, visited, currentPath, adj)) return true;
        }

        visited.add(node);
        currentPath.remove(node);

        return false;
    }
}
