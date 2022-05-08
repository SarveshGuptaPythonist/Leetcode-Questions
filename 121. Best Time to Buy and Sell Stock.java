class Solution {
    public int maxProfit(int[] stocks) {
        int n = stocks.length;
        int min = stocks[0];
        int maxProfit = 0;
        // boolean closed = open;
        for(int i = 0; i < n; i++) { min = Math.min(min, stocks[i]); maxProfit = Math.max(maxProfit, stocks[i] - min);}
        return maxProfit;
    }
}
