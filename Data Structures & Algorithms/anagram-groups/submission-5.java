class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] counts = new int[26];
            for(char c: str.toCharArray()) {
                counts[c-'a']++;
            }
            String objectiveString = Arrays.toString(counts);
            map.putIfAbsent(objectiveString, new ArrayList<String>());
            map.get(objectiveString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
