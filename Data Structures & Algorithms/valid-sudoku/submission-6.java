class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    String s = "{" + board[i][j] + "}";
                    if(!seen.add(s+i) || !seen.add(j + s) || !seen.add(i/3 + s + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
