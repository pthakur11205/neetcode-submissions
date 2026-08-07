class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> supermap = new HashMap<>();
        Map<Character, Integer> tupermap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            supermap.put(s.charAt(i), supermap.getOrDefault(s.charAt(i), 0) + 1);
            tupermap.put(t.charAt(i), tupermap.getOrDefault(t.charAt(i), 0) + 1);
        }
        if(supermap.equals(tupermap)) {
            return true;
        }
        return false;
    }
}
