class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> mh = new PriorityQueue<>((a,b) -> Integer.compare(b[0]*b[0]+b[1]*b[1], a[0]*a[0]+a[1]*a[1]));

        for(int[] p: points) {
            mh.offer(p);
            if(mh.size() > k) {
                mh.poll();
            }
        }

        int[][] res = new int[k][2];
        int i=0;
        while(!mh.isEmpty()) {
            res[i++] = mh.poll();
        }

        return res;


    }
}
