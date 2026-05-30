class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while((right -  left + 1) > k) {
            int diffL = Math.abs(arr[left] - x);
            int diffR = Math.abs(arr[right] - x);

            if(diffL > diffR) {
                left++;
            } else if(diffL <= diffR) {
                right--;
            } 
        }

        for(int i= left; i<= right; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}