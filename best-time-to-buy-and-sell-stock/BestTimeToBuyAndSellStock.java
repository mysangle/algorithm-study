public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
 
        int low = prices[0];
        int high = 0;
        int profit = 0;
        int prev, current;
        for (int i = 1; i < prices.length; i++) {
            prev = prices[i-1];
            current = prices[i];
            if (prev > current) {
                low = Math.min(low, current);
            }
            if (prev < current) {
                high = current;
                profit = Math.max(high - low, profit);
            }
        }
        return profit;
    }
}
