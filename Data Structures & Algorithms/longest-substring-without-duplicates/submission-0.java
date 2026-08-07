class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int res = 0;
        Set<Character> seenChars = new HashSet<>();

        for(int r = 0; r < s.length(); r++) {

            while(seenChars.contains(s.charAt(r))) {
                seenChars.remove(s.charAt(l));
                l++;
            }

            seenChars.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
