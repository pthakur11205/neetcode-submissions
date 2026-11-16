class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int n: nums) seen.add(n);
        int res = 0;
        for(int n: nums) {
            int length = 0;
            if(!seen.contains(n-1)) {
                while(seen.contains(n+length)) {
                    length++;
                }
            }
            res = Math.max(res, length);
        }
        return res;
    }
}
