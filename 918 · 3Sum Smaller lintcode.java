public class Solution {
    /**
     * @param nums:  an array of n integers
     * @param target: a target
     * @return: the number of index triplets satisfy the condition nums[i] + nums[j] + nums[k] < target
     */
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int totalAns = 0;
        int ans;
        for(int i = 0; i < nums.length-2; i++) {
            ans = twoSum(nums, i+1, nums.length-1, target - nums[i]);
            totalAns += ans;
        }
        return totalAns;
    }
    public int twoSum(int[] nums, int left, int right, int target) {
        int ans = 0;
        while(left < right) {
           
            int sum = nums[left] + nums[right];
            
            if(sum < target) {
                    ans+= right-left;
                    left++;
                }
                else {
                    right--;
                }
        }
        return ans;
    }
}
