class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_ = float('-inf')
        add = 0
        for num in nums:
                
            add += num
            
            max_ = max(add, max_)
            if add < 0:
                add = 0
        
        return max_
        
