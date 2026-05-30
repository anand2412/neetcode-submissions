class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount =0;
        int maxLen = 0; 
        while(r < s.length()) {
            
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxCount = Math.max(maxCount, map.get(ch));
            
            while(r - l + 1 - maxCount > k) {
                char temp = s.charAt(l);
                map.put(temp, map.getOrDefault(temp, 0)-1);
                if(map.get(temp) <= 0) {
                    map.remove(temp);
                }
                l++;
            }
            int len = r-l+1;
            maxLen = Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
}
