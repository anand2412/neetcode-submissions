class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            adjList.get(src).add(dest);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!visited.contains(i)) {
                if(hasCycle(i, visited, currentPath, adjList)) return false;
            }
        }

        return true;
    }

    public boolean hasCycle(int node, Set<Integer> visited, Set<Integer> currentPath, List<List<Integer>> adjList) {
        if(visited.contains(node)) return false;
        if(currentPath.contains(node)) return true;

        currentPath.add(node);

        for(int n : adjList.get(node)) {
            if(hasCycle(n, visited, currentPath, adjList)) return true;
        }

        visited.add(node);
        currentPath.remove(node);

        return false;
    }
}
