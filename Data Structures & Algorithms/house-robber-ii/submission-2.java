class Solution {
    public int rob(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    if (n == 1) return nums[0];

    int oneWay = robLinear(nums, 0, n - 2);  // Exclude last house
    int secondWay = robLinear(nums, 1, n - 1);  // Exclude first house

    return Math.max(oneWay, secondWay);
}

// Helper for normal House Robber on subarray [start...end]
private int robLinear(int[] nums, int start, int end) {
    int n = end - start + 1;
    if (n == 1) return nums[start];
    int[] dp = new int[n];
    dp[0] = nums[start];
    dp[1] = Math.max(nums[start], nums[start + 1]);

    for (int i = 2; i < n; i++) {
        dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
    }

    return dp[n - 1];
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
