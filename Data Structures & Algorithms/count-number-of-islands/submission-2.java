class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[]  dr = {-1, 1, 0, 0};
        int[]  dc = {0, 0, -1, 1};

        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()) {
                        int [] curr = q.poll();
                        for(int k=0; k < 4; k++) {
                            int nr = curr[0] + dr[k];
                            int nc = curr[1] + dc[k];
                            if(nr >= 0 && nr < m  && nc >= 0 && nc <n && grid[nr][nc] == '1') {
                                grid[nr][nc] ='0';
                                q.add(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
