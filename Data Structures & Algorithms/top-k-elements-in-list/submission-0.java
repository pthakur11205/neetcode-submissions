class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> supermap = new HashMap<>();
        List<Integer>[] arr = new List[nums.length+1];
        
        for(int i = 0; i < nums.length; i++) {
            supermap.put(nums[i], supermap.getOrDefault(nums[i], 0) + 1);
            arr[i+1] = new ArrayList<Integer>();
        }
        System.out.print(supermap);
        for(Map.Entry<Integer, Integer> entry: supermap.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }
        
        int[] result = new int[k];
        int index = 0;
        for(int j = arr.length-1; j > 0 && index < k; j--) {
            if(arr[j].isEmpty()) {
                continue;
            }
            for(int b: arr[j]) {
                result[index++] = b;
            }
        }
        return result;
    }
}
