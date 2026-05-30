class Solution {
    public int maxSubArray(int[] nums) {
              
        int r = 0;
        int sum = 0;
        int maxSum = nums[0];
        while(r < nums.length) {
            if(sum < 0) {
                sum = 0;
            } 
            sum += nums[r];
            maxSum = Math.max(maxSum, sum);
            r++;
            
        }
        return maxSum;
    }
}
