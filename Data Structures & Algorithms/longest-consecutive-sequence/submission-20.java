class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num: nums) {
            set.add(num);
        }
        for(int n: set) {
            if(!set.contains(n-1)) {
                int length = 1;
                while(set.contains(n+length)) {
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
