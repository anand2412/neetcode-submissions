class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int m = image.length;
        int n = image[0].length;
        int oldC = image[sr][sc];

        dfs(sr, sc, m, n, image, oldC, color);

        return image;
    }

    public void dfs(int r, int c, int m, int n,int[][]image, int oldC, int newC) {
        if(r < 0 || c < 0 || r >= m || c >= n || image[r][c] == newC || image[r][c] != oldC) {
            return;
        }

        image[r][c] = newC;

        dfs(r+1, c, m, n, image, oldC, newC);
        dfs(r-1, c, m, n, image, oldC, newC);
        dfs(r, c+1, m, n, image, oldC, newC);
        dfs(r, c-1, m, n, image, oldC, newC);

    }
}