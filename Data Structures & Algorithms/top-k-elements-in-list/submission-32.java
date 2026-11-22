class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> counts = new HashMap<>();
        for(int n: nums) {
            counts.put(n, counts.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            int count = entry.getValue();
            int num = entry.getKey();
            pq.offer(new int[]{count, num});
            if(pq.size()>k) pq.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }

        return res;
    }
}
