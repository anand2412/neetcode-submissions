class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        boolean visited[][] = new boolean[m][n];
        visited[0][0] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i < size; i++) {
                int [] curr = queue.poll();
                if(curr[0] == m-1 && curr[1] == n-1) return count;
                for(int k=0; k < 8; k++) {
                    int nr = curr[0] + dr[k];
                    int nc = curr[1] + dc[k];
                    if(nr >=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}