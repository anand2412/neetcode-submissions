class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(dp, nums.length-1, nums);
    }

    public int solve(int[] dp, int index, int[] nums) {
        if(index == 0) {
            return nums[0];
        }
        if(index < 0) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }
        
        int pick = nums[index] + solve(dp, index-2, nums);
        int nPick = solve(dp, index-1, nums);
        dp[index]= Math.max(pick, nPick);
        return dp[index];
    }
}
