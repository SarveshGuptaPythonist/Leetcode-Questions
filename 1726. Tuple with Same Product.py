class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        dict_ = {}
        for i in range(len(nums)):
            for j in range(len(nums)):
                if i!=j:
                    prod = nums[i] * nums[j]
                    if prod not in dict_:
                        dict_[prod] = []
                    dict_[prod].append([nums[i], nums[j]])
        count = 0
        list_ = []
        count = 0
        for k in dict_:
            if len(dict_[k]) > 2:
                list_.append([k, len(dict_[k])])
                count += len(dict_[k]) * (len(dict_[k])-2)
        
        return count
