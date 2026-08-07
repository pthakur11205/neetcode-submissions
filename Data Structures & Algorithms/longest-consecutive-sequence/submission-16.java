class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int res = 0;
        for(int n: set) {
            int length = 1;
            if(!set.contains(n-1)) {
                while(set.contains(n+length)) {
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
