class Solution {
    public int maxProfit(int[] prices) {
        // int res = 0;
        // for(int i = 0; i < prices.length; i++) {
        //     int buy = prices[i];
        //     for(int j = i+1; j < prices.length; j++) {
        //         int sell = prices[j];
        //         res = Math.max(res, sell - buy);
        //     }
        // }
        // return res;

        int l = 0;
        int r = 1;
        int maxProf = 0;
        while(r < prices.length) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxProf = Math.max(maxProf, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProf;

    }
}
