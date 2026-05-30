class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n+m];
        Arrays.fill(res, 0);
        int carry =0;
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                int val = (num1.charAt(i) -'0')*(num2.charAt(j) -'0') ;
                int sum = val + res[i+j+1] + carry;
                res[i+j+1] = sum % 10;
                carry = sum / 10;       
            }

            if (carry != 0) {
               res[i] += carry;
               carry = 0;
            }
        }

        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<res.length; i++) {
            if(sb.length() ==0 && res[i] == 0) {
               continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
