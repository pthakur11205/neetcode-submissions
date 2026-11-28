class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, 0);
        return res;
    }

    private void backtrack(String s, int j, int i) {
        if(i>=s.length()) {
            if(i==j) res.add(new ArrayList<>(part));
            return;
        }

        if(isPal(s, j, i)) {
            part.add(s.substring(j, i+1));
            backtrack(s, i+1, i+1);
            part.remove(part.size()-1);
        }

        backtrack(s, j, i+1);
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
