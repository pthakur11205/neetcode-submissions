class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char letterS = s.charAt(i);
            char letterT = t.charAt(i);

            sMap.put(letterS, sMap.getOrDefault(letterS, 0) + 1);
            tMap.put(letterT, tMap.getOrDefault(letterT, 0) + 1);
        }
        if(sMap.equals(tMap)) {
            return true;
        } else {
            return false;
        }
    }
}
