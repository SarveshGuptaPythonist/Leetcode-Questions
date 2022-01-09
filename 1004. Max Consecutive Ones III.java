class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int currZeros = 0;
        int max = 0;
        while(left <= right && right < nums.length) {
            int curr = nums[right];
            if(curr == 1) {
                max = Math.max(max, right - left + 1);
            }
            else {
                    currZeros++;
                    while(currZeros > k) {
                        if(nums[left] == 0){
                            currZeros--;
                        }
                        left++;
                    }
                }
            
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}
