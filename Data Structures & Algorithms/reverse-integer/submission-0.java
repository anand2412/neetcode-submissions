class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;

        int org = x;
        int rev =0;
        boolean isNegative = x <0 ? true : false;
        x = Math.abs(x);
        while(x != 0) {
            int digit = x%10;
            if(rev > (max - digit)/10) {
                return 0;
            }
            rev = rev*10 + digit;
            x=x/10;
        }

        return isNegative?-rev:rev;
    }
}
