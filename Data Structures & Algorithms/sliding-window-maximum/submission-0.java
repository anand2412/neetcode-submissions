class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = left + k -1;
        List<Integer> res= new ArrayList<>();
        while(right < nums.length) {
            int max = Integer.MIN_VALUE;
            for(int i=left; i<= right; i++) {
                max = Math.max(max, nums[i]);
            }
            res.add(max);
            left++;
            right++;
        }
        int [] r = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
