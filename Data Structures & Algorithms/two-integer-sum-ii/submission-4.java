class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j=0;
        int k = numbers.length-1;
        while(j < k) {
            if(numbers[j]+ numbers[k]== target) {
                return new int[] {j+1, k+1};
            } else if(numbers[j]+ numbers[k] < target) {
                j++;
            } else {
                k--;
            }
        }
        return new int[0];
    }
}
