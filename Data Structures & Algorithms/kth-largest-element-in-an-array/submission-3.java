class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> mh = new PriorityQueue<>();
        for(int n: nums) {
            mh.offer(n);
            if(mh.size()>k) {
                mh.poll();
            }
        }
        return mh.peek();
    }
}
