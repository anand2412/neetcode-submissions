class Solution {

    int INF = (int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[][]dp = new int[n][amount+1];
        //second way

        for(int target=0; target<= amount; target++) {
            if(target % coins[0] == 0) {
                dp[0][target] = target / coins[0];
            } else {
                 dp[0][target] = INF;
            }
        }

        for(int index =1; index<n; index++) {
            for(int target=0; target<=amount; target++) {
                int pick = INF;
                if (coins[index] <= target) {
                   pick = 1 + dp[index][target - coins[index]];
                }
                int nPick = dp[index-1][target];
                dp[index][target] = Math.min(pick, nPick);
            }
        }


        int res = dp[n-1][amount];
        return res == INF ? -1 : res;
    }

    public int solve(int[] coins, int target, int[][] dp, int index) {      
        if(index == 0) {
            if (target % coins[0] == 0) return target / coins[0];
            else return INF;
        }
        if(target == 0) {
            return 0;
        }
        
        if(dp[index][target] != -1) return dp[index][target];
        
        int pick = INF;
        if (coins[index] <= target) {
            pick =1 + solve(coins, target - coins[index], dp, index);
        }

        int nPick = solve(coins, target, dp, index - 1);
        return dp[index][target] = Math.min(pick, nPick);
    }
}
