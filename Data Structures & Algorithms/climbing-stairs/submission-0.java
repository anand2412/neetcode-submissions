class Solution {
    public int climbStairs(int n) {
        
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(dp, n);
    }

    public int solve(int[] dp, int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if(n == 1) return 1;

        if(dp[n] != -1) {
            return dp[n];
        }
        int left = 0;
        int right =0;
        if(n >= 1) {
            left = solve(dp, n - 1);
        }
        if(n >= 2) {
            right = solve(dp, n-2);
        }
        dp[n] =  right+ left;
        return dp[n];
    }
}
