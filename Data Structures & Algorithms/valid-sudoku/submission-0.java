class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char curr_val = board[i][j];
                if(curr_val != '.') {
                    if(!set.add(curr_val+" found in a row "+i) ||
                    !set.add(curr_val+" found in a col "+j) ||
                    !set.add(curr_val+" found in a box "+i/3 +"-"+j/3)) 
                    return false;
                }
            }
        }
        return true;
    }
}
