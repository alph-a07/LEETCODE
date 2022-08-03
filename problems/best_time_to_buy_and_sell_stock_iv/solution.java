class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0)
            return 0;

        int[][] storage = new int[k + 1][prices.length];

        for (int trxn = 1; trxn <= k; trxn++) {
            int max = Integer.MIN_VALUE;
            for (int day = 1; day < prices.length; day++) {
                int prev_profit = storage[trxn][day - 1];

                max = Math.max(max, -prices[day - 1] + storage[trxn - 1][day - 1]);

                storage[trxn][day] = Math.max(prev_profit, prices[day] + max);
            }
        }
        return storage[k][prices.length - 1];
    }
}
