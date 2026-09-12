class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), s, 0, 0);
        return res;
    }


    private void backtrack(List<String> cur, String s, int j, int i) {
        if(i >= s.length()) {
            if(j==i) res.add(new ArrayList<>(cur));
            return;
        }

        if(isPal(s, j, i)) {
            cur.add(s.substring(j, i+1));
            backtrack(cur, s, i+1, i+1);
            cur.remove(cur.size()-1);
        }

        backtrack(cur, s, j, i+1);

    }

    private boolean isPal(String s, int l, int r) {
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
