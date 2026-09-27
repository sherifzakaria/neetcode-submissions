class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while (j < prices.length) {
                profit = Math.max(prices[j] - prices[i], profit);
                j++;
            }
        }
        return profit;
    }
}
