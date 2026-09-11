class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        backtrack(res, part, s, 0, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> part, String s, int j, int i) {
        if(i >= s.length()) {
            if(i==j) res.add(new ArrayList<>(part));
            return;
        }

        if(isPal(s, j, i)) {
            part.add(s.substring(j, i+1));
            backtrack(res, part, s, i+1, i+1);
            part.remove(part.size()-1);
        }

        backtrack(res, part, s, j, i+1);
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
