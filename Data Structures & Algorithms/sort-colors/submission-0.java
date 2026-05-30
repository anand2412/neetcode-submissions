class Solution {
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for(int i=0; i< nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
            } else if(nums[i] == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }
        for(int i =0; i< nums.length; i++) {
            if(zeroCount-- > 0)
               nums[i] = 0;
            else if(oneCount-- > 0)
               nums[i] = 1;
            else if(twoCount-- > 0)
               nums[i] = 2;
        }
    }
}