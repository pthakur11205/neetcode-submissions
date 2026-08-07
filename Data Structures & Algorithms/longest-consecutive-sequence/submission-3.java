class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        
        int seq = 1;
        int max = 0;
        for(int nummy: set) {
            while(set.contains(nummy+seq)) {
                seq++;
            }
            max = Math.max(max, seq);
            seq = 1;
        }
        return max;
    }
}
