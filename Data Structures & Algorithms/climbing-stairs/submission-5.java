class Solution {
    public int climbStairs(int n) {
        //third way
        if (n <= 2) {
            return n;
        }

        int prev  = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev + prev2;
            prev = prev2;
            prev2 = curr;          
        }
        return prev2;
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
