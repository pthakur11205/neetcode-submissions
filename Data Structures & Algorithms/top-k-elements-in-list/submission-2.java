class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        for(int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for(int i = 0; i < nums.length+1; i++) {
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int j = freq.length - 1; j > 0 && index < k; j--) {
            for(int n: freq[j]) {
                res[index++] = n;
                if(index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
