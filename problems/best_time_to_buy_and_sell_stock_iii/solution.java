class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;

        int[] sellToday = new int[prices.length];
        int[] buyToday = new int[prices.length];

        int min_buy = Integer.MAX_VALUE;
        // stores maximum profit possible "on/after" each day if sold on/before that day
        for (int i = 0; i < sellToday.length; i++) {
            min_buy = Math.min(min_buy, prices[i]);
            if (i != 0)
                sellToday[i] = Math.max(sellToday[i - 1], prices[i] - min_buy);
        }

        // stores maximum profit possible "on/after" each day if sold on/after that day
        int max_sell = Integer.MIN_VALUE;
        for (int i = buyToday.length - 1; i >= 0; i--) {
            max_sell = Math.max(max_sell, prices[i]);

            if (i != buyToday.length - 1)
                buyToday[i] = Math.max(buyToday[i + 1], max_sell - prices[i]);
        }

        int total = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            total = Math.max(total, sellToday[i] + buyToday[i]);
        }

        return total;
    }
}
