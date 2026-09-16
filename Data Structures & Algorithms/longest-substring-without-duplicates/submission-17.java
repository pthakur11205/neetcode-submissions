class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int res = 0;
        Set<Character> seen = new HashSet<>();
        while(r<s.length()) {
            while(seen.contains(s.charAt(r)) && l < s.length()) {
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(s.charAt(r));
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}
