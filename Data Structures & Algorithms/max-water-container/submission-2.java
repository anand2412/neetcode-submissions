class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j = heights.length -1;
        int max = Integer.MIN_VALUE;
        while(i < j) {
            int area = Math.min(heights[i], heights[j]) * (j-i);
            max= Math.max(max, area);
            if(heights[i] < heights[j]) {
                i++;
            } else if(heights[i] > heights[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return max;
    }
}
