class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> supermap = new HashMap<>();
        for(String str: strs) {
            int[] count = new int[26];
            for(char c: str.toCharArray()) {
                count[c-'a']++;
            }
            if(supermap.containsKey(Arrays.toString(count))) {
                supermap.get(Arrays.toString(count)).add(str);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                supermap.put(Arrays.toString(count), newList);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(List<String> value: supermap.values()) {
            result.add(value);
        }
        return result;
    }
}
