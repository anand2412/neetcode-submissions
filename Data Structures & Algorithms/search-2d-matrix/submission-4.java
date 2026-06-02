class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int [] colArr = new int[m];
        for(int i=0; i<m; i++) {
           colArr[i] = matrix[i][n-1];
        }

        int rowIndex = search(colArr, target);
         if (rowIndex >= m) return false;
        if(colArr[rowIndex] == target) return true;
        
        int [] rowArray = new int[n];
        for(int i=0; i<n; i++) {
            rowArray[i] = matrix[rowIndex][i];
        }

        int colIndex = search(rowArray, target);
        if(colIndex < n && rowArray[colIndex] == target) return true;
        return false;
    }

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1; 
            }
        }
        return left;
    }
}
