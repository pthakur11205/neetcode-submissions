class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=1;
        int m =0;
        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                int prof = prices[r] - prices[l];
                m = Math.max(m, prof);
            } else {
                l=r;
            }
            r++;
        }
        return m;
    }
}
