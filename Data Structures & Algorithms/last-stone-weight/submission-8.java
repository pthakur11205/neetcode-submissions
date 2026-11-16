class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> mh = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int stone: stones) {
            mh.offer(stone);
        }
        while(mh.size() > 1) {
            int x = mh.poll();
            int y = mh.poll();
            if(x!=y) mh.offer(Math.abs(y-x));
        }

        return (mh.isEmpty()) ? 0: mh.peek();
    }
}
