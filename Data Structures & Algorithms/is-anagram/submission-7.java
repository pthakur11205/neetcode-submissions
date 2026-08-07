class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            count[sChar - 'a']++;
            count[tChar - 'a']--;
        }
        for(int cnt: count) {
            if(cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
