class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    convertLandToWater(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void convertLandToWater(char[][] grid, int i, int j) {
        if(i < 0 || j<0 || i>=grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        convertLandToWater(grid, i+1, j);
        convertLandToWater(grid, i, j+1);
        convertLandToWater(grid, i-1, j);
        convertLandToWater(grid, i, j-1); 
    }
}
