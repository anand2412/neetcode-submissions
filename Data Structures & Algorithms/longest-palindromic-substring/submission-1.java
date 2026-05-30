class Solution {
    public String longestPalindrome(String s) {
		int n = s.length();
		String reverse = new StringBuilder(s).reverse().toString();
       
        
        int endInx = 0;
		int maxLen = 0;
		int [] prev = new int[n+1];
		int[] curr = new int[n+1];
		for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(s.charAt(i-1) == reverse.charAt(j-1)) {
        			curr[j] = 1 + prev[j-1];
        			
        			int beforeReverse = n - j;
        			if(beforeReverse + curr[j] - 1 == i-1) {
        				if(curr[j] > maxLen ) {
        					maxLen = curr[j];
        					endInx  = i;
        				}
        			}
        			
        		} else {
        			curr[j] = 0;
        		}
        	}
        	prev= curr.clone();
        }
        return s.substring(endInx - maxLen, endInx);
	}
}
