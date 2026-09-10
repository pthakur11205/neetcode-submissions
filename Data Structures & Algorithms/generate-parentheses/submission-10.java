class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(res, stack, n, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder stack, int n, int open, int closed) {
        if(closed == open && open == n) {
            res.add(stack.toString());
            return;
        }

        if(open < n) {
            stack.append("(");
            backtrack(res, stack, n, open+1, closed);
            stack.deleteCharAt(stack.length()-1);
        }

        if(closed < open) {
            stack.append(")");
            backtrack(res, stack, n, open, closed+1);
            stack.deleteCharAt(stack.length()-1);
        }


    }
}
