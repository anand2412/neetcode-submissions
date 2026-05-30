class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> revAdjacencyList = new ArrayList<>(numCourses);
        int [] degreeArray = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            revAdjacencyList.add(new ArrayList<>());
        }

        // Step 2: Populate the adjacency list based on prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            revAdjacencyList.get(course).add(prerequisiteCourse);
            degreeArray[prerequisiteCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degreeArray[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int course = queue.poll();

            result.add(course);

            for(int pre : revAdjacencyList.get(course)) {
                if(--degreeArray[pre] == 0) {
                    queue.offer(pre);
                }
            }
        }

       return (result.size() == numCourses); 
    }

    
}
