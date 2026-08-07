class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int length = 0;
        for(int n: set) {
            if(!set.contains(n-1)) {
                length = 1;
                while(set.contains(n+length)) {
                    length++;
                }
                res = Math.max(res, length);
            }   
        }
        return res;
    }
}
