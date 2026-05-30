class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char c: t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }
        int required= tmap.size();
        int formed = 0;
        int l =0;
        int r =0;
        int minLen = Integer.MAX_VALUE;
        int start =0;
        HashMap<Character, Integer> smap = new HashMap<>();
        while(r < s.length()) {
            char ch = s.charAt(r);
            smap.put(ch, smap.getOrDefault(ch, 0)+1);
            if(tmap.containsKey(ch) && tmap.get(ch) == smap.get(ch)) {
                formed++;
            }
            
            if(formed == required) {
                while(formed == required) {
                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        start = l;
                    }
                    char left = s.charAt(l);
                    smap.put(left, smap.getOrDefault(left, 0)-1);
                    if(tmap.containsKey(left) && smap.get(left) < tmap.get(left)) {
                        formed--;
                    }
                    l++;
                }
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
