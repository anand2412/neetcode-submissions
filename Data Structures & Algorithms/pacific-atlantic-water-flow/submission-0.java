class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        for(int i=0; i<m; i++) {
            pacificQ.add(new int[] {i,0});
            pacific[i][0] = true;
        }

        for(int j=0; j<n; j++) {
            pacificQ.add(new int[] {0,j});
            pacific[0][j] = true;
        }

        for(int i=0; i < m; i++) {
            atlanticQ.add(new int[] {i,n-1});
            atlantic[i][n-1] = true;
        }

        for(int j=0; j<n; j++) {
            atlanticQ.add(new int[] {m-1,j});
            atlantic[m-1][j] = true;
        }

        bfs(heights, pacific, pacificQ, m, n);
        bfs(heights, atlantic, atlanticQ, m, n);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] heights, boolean[][] visited, 
                 Queue<int[]> queue, int m, int n) {

        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,1,-1};

        while(!queue.isEmpty()) {
            int [] curr = queue.poll(); 
            for(int k =0; k <4; k++) {
                int nr = curr[0] + dr[k];
                int nc = curr[1] + dc[k];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && heights[curr[0]][curr[1]] <= heights[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                }
            }
        }

    }
}
