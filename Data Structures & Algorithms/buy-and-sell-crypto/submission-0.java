class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxPrice = 0;
        for (int i=prices.length-1; i>=0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
        }
        return maxProfit;
    }
}
