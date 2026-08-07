class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = Arrays.stream(piles).max().getAsInt();
        int k = r;
        while(l <= r) {
            int mid = (l+r)/2;
            long time = 0;
            for(int p: piles) {
                time += Math.ceil((double) p/mid);
            }
            if(time > h) {
                l = mid+1; 
            } else {
                k=mid;
                r = mid-1;
            }
        }
        return k;
    }
}
