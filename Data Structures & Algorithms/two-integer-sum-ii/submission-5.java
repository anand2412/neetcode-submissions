class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lPointer = 0;
        int rPointer = numbers.length -1;
        while(lPointer < rPointer) {
            if(numbers[lPointer] + numbers[rPointer] ==target) {
                return new int[] {lPointer+1, rPointer+1};
            } else if(numbers[lPointer] + numbers[rPointer] > target) {
                rPointer--;
            } else if(numbers[lPointer] + numbers[rPointer] < target) {
                lPointer++;
            } 
        }

        return new int[]{};
    }
}
