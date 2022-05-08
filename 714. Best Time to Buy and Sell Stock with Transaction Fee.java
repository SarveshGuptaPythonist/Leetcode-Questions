class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        
        for(int i = 0; i < prices.length; i++) {
            int newBuy = Math.max(buy, sell - prices[i]);
            int newSell = Math.max(sell, buy + prices[i] - fee);
            buy = newBuy;
            sell = newSell;
        }
        return sell;
    }
}

// In this we have found our old max and min, now we will compare our newbuy with old buy and will see if it is profitable with old buy.
// Similarly when selling old you will see, if you get more profit you can sell.
