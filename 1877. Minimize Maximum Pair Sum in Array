class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        // int[] halve = new int[nums.length / 2];
        int max = 0;
        for(int i = 0; i < nums.length / 2; i++){
            // halve[i] = nums[i] + nums[nums.length - i - 1];
            max = Math.max(nums[i] + nums[nums.length - i - 1], max);
        }
        return max;
        
    }
}
