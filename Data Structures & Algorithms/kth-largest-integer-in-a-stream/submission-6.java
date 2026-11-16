class KthLargest {

    private PriorityQueue<Integer> mh;
    private int k;

    public KthLargest(int k, int[] nums) {
        mh = new PriorityQueue<>();
        this.k = k;
        for(int n: nums) {
            mh.offer(n);
            if(mh.size() > k) mh.poll();
        } 
    }
    
    public int add(int val) {
        mh.offer(val);
        if(mh.size()>k) mh.poll();
        return mh.peek();
    }
}
