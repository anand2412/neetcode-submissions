class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longest = 0;
        if(n == 0 || n == 1) {
            return nums.length;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {
            if(!set.contains(num-1)){
                int len = 1;
                while(set.contains(num+len)) {
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}
