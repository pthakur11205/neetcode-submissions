class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        
        while(l <= r) {
            int mid = (l + r)/2;
            long time = 0;
            for(int i = 0; i < piles.length; i++) {
                time += Math.ceil((double) piles[i]/mid);
            }
            if(time > h) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}
