class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s.length();
        } 
        int l = 0;
        int r = 1;
        int maxLen = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        while(r < s.length()) {
            if(map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)) + 1);
                map.put(s.charAt(r), r);
            } 
            map.put(s.charAt(r), r);
            int len = r-l+1;
            maxLen = Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
}
