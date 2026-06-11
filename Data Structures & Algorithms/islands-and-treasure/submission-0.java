class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int INF = Integer.MAX_VALUE;;

        int dr[] = {-1,1,0,0};
        int dc[] = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[] {i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            int [] curr = q.poll();

            for(int k = 0; k < 4; k++) {
                int nr = curr[0] + dr[k];
                int nc = curr[1] + dc[k];

                if(nr >= 0 && nc >= 0 && nr < m && nc <n && grid[nr][nc] == INF) {
                    grid[nr][nc] = 1 + grid[curr[0]][curr[1]];
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
 