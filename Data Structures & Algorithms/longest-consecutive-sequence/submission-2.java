class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            int length = 0;
            if(!set.contains(num-1)) {
                while(set.contains(num++)) {
                    length++;
                }

                maxLen = Math.max(length, maxLen);
            }
        }
        return maxLen;
    }
}
