class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int oneWay = solve(dp, nums, n-1, 1);
         Arrays.fill(dp, -1);
        int secondWay = solve(dp, nums, n-2, 0);
        return Math.max(oneWay, secondWay);
    }

    public int solve(int[] dp, int[] nums, int index, int start) {
        if(index == start) {
            return nums[start];
        }
        if(index < start) {
            return 0;
        }
        if(dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + solve(dp, nums, index -2, start);
        int nPick =  solve(dp, nums, index -1, start);

        dp[index] = Math.max(pick, nPick);
        return dp[index];
    }
}
