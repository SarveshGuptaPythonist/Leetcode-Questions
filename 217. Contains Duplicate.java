class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) > len(set(nums))
        '''
        set_ = set()
        for i in nums:
            if i in set_:
                return True
            else:
                set_.add(i)
        return False
        '''
        
        
