class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        el = 0
        count = 0
        for num in nums:
            if count == 0:
                el = num
                count = 1
            elif el == num:
                count += 1
            else:
                count -= 1
        
        # total_current_count_in_nums = nums.count(count) Assuming that it will always have the largest value
        return el
        
