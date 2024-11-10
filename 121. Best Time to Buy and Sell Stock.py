class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min_ = float('inf')
        max_profit = 0

        for price in prices:    
            min_ = min(min_, price)

            curr_profit = price - min_

            if curr_profit > max_profit:
                max_profit = curr_profit
        
        return max_profit

        
