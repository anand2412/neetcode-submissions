class Solution {
     public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;
        for(int i=0; i < m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(calculteMax(i,j,m,n,grid, 0), max);
                }
            }
        }

        return max;
    }

    public int calculteMax(int i, int j, int m, int n, int[][] grid, int sum) {
        if(i < 0 || j<0 || i>=m || j>=n || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int lSum = calculteMax(i, j-1, m, n, grid, sum + 1);
        int rSum = calculteMax(i, j+1, m, n, grid, sum + 1);
        int uSum = calculteMax(i-1, j, m, n, grid, sum + 1);
        int dSum = calculteMax(i+1, j, m, n, grid, sum + 1);

        return lSum + rSum + uSum + dSum + 1;
    }
}
