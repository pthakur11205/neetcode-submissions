class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> sqs = new HashMap<>();
        for(int r=0; r < 9; r++) {
            for(int c=0; c < 9; c++) {
                char pos = board[r][c];
                if(pos == '.') continue;
                String sqPos = (r/3)+","+(c/3);
                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(pos) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(pos) ||
                    sqs.computeIfAbsent(sqPos, k -> new HashSet<>()).contains(pos)) {
                        return false;
                }

                rows.get(r).add(pos);
                cols.get(c).add(pos);
                sqs.get(sqPos).add(pos);
            }
        }
        return true;
    }
}
