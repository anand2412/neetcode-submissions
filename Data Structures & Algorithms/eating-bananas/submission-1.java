class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int kMin = 1;
        int kMax = 0;
        for (int p : piles) {
            kMax = Math.max(kMax, p);
        }
        int ans = 0;
        while(kMin <= kMax) {
            int hours = 0;
            int mid = kMin + (kMax - kMin) /2;
            for(int p : piles) {
                if(p <= mid) hours++;
                else {
                    int d = p / mid;
                    if (p % mid == 0) {
                        hours += d;
                    } else {
                        hours += d + 1;
                    }
                }
            }
            if (hours <= h) {
                ans = mid;
                kMax = mid - 1;
            } else {
                kMin = mid + 1;
            }
        }

        return ans;
    }
}
