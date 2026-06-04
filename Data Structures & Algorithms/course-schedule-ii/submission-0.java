class Solution {
    List<Integer> result = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            adjList.get(src).add(dest);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!visited.contains(i)) {
                if(hasCycle(i, adjList, visited, currentPath)) {
                    return new int[]{};
                }
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, 
                          Set<Integer> visited, Set<Integer> currentPath) {
        if(visited.contains(node)) {
            return false;
        }
        if(currentPath.contains(node)) {
            return true;
        }
        
        currentPath.add(node);
        for(int n : adj.get(node)) {        
            if(hasCycle(n, adj, visited, currentPath)) {
                return true;
            }   
        }
        result.add(node);
        visited.add(node);
        currentPath.remove(node); 

        return false;
    }
}
