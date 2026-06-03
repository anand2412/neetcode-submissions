class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        int ans = right;

        while(left <= right) {
            int mid = left + (right - left)/2;

            int currDays = 1;
            int weightSum = 0;
            for(int w : weights) {
                weightSum += w;
                if(weightSum > mid) {
                    currDays++;
                    weightSum = w;
                }
            }
            if(currDays <= days) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}