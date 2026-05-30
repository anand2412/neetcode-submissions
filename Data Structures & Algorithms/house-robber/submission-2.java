class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[nums.length+1];
       // Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            int pick = nums[i] + dp[i-2];
            int nPick = dp[i-1];
            dp[i] = Math.max(pick, nPick);
        }
        return dp[nums.length-1];
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
