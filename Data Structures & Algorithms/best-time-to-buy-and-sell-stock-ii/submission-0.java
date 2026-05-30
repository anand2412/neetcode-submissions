class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        int ans = 0;
        for(int price: prices) {
            minPrice = Math.min(price, minPrice);
            if(price - minPrice > 0){
                ans += (price - minPrice);
                minPrice = price;
            }
        }

        return ans;
    }
}