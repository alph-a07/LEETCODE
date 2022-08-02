class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        // we know all day prices
        // If today's price is more than yesterday then it will contribute to profit 
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
