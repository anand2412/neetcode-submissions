class Solution {
    public int longestConsecutive(int[] nums) {
       int n  = nums.length;
       if(n == 0) {
        return 0;
       } 

       Arrays.sort(nums);
       int count =1; int max =1;
       for(int i=0; i<n-1; i++) {
        if(nums[i]== nums[i+1]) {
            continue;
        }
        if(nums[i]- nums[i+1] == -1) {
            count++;
        } else {
            max = Math.max(count, max);
            count=1;
        }
       }
       max =Math.max(max, count);
       return max;
    }
}
