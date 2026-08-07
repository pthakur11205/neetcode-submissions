class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=0;
        int hi = Arrays.stream(piles).max().getAsInt();
        int k = hi;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            long time = 0;
            for(int p: piles) {
                time += Math.ceil((double) p/mid);
            }
            if(time > h) {
                lo=mid+1;
            } else {
                k = mid;
                hi = mid-1;
            }
        }
        return k;
    }
}
