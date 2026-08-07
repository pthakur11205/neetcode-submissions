class Solution {
    public int maxProfit(int[] prices) {
        int profitResult = 0;
        int left = 0;
        int right = 1;
        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                int prof = prices[right] - prices[left];
                profitResult = Math.max(profitResult, prof);
            } else {
                left = right;
            }
            right++;
        }
        return profitResult;
    }
}
