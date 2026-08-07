class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int res=0;
        Set<Character> seen = new HashSet<>();
        for(int i=0; i < s.length(); i++) {
            while(seen.contains(s.charAt(i))) {
                seen.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, i-l+1);
            seen.add(s.charAt(i));
        }
        return res;
    }
}
