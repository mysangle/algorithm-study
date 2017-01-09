public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
 
        int low = prices[0];
        int high = 0;
        int profit = 0;
        int maxProfit = 0;
        int prev, current;
        for (int i = 1; i < prices.length; i++) {
            prev = prices[i-1];
            current = prices[i];
            if (prev > current) {
                if (high > low) {
                    maxProfit += (high - low);
                }
                low = current;
                high = 0;
            } else if (prev < current) {
                high = current;
            }
        }
        if (high != 0) {
            maxProfit += (high - low);
        }
        return maxProfit;
    }
}
