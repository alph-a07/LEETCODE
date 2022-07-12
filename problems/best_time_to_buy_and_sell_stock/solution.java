class Solution {
    public int maxProfit(int[] prices) {
        int leastBuy = Integer.MAX_VALUE;
        int tempProfit = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
           leastBuy = Math.min(prices[i],leastBuy);
           tempProfit = prices[i] - leastBuy;
           profit = Math.max(tempProfit,profit);
        }
        return profit;
    }
}
