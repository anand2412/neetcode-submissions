class Solution {
    public int trap(int[] height) {
        int lPointer = 0;
        int rPointer = height.length -1;
        int area =0;
        int leftMax = 0;
        int rightMax = 0;
        int water =0;
        while(lPointer < rPointer) {
            if(height[lPointer] < height[rPointer]) {
                if(leftMax < height[lPointer]) {
                    leftMax = height[lPointer];
                } else {
                    water += leftMax - height[lPointer];
                }
                lPointer++;
            } else {
                if(rightMax < height[rPointer]) {
                    rightMax = height[rPointer];
                } else {
                    water += rightMax - height[rPointer];
                }
                rPointer--;
            }
        }
        return water;
    }
}
