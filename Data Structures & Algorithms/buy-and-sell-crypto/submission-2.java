class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyingIdx = 0;
        int sellingIdx = 0;

        while (buyingIdx < prices.length - 1) {
            sellingIdx = buyingIdx + 1;
            while (sellingIdx < prices.length && prices[sellingIdx] > prices[buyingIdx]) {
                profit = Math.max(prices[sellingIdx] - prices[buyingIdx], profit);
                sellingIdx++;
            }
            buyingIdx = sellingIdx;
        }

        return profit;
    }
}
