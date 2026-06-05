class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j =0; j<n; j++) {
                if(grid[i][j] == 2) queue.add(new int[] {i,j});
            }
        }
        int fresh  =0;
         for(int i=0; i<m; i++) {
            for(int j =0; j<n; j++) {
                if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;

        int time = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for(int k=0; k<4; k++) {
                    int nr = curr[0] + dr[k];
                    int nc = curr[1] + dc[k];
                    if(nr >=0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr, nc});
                    } 
                }
            }
            time++;;
        }

        if(fresh > 0) return -1;
        return time;
    }
}
