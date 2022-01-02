class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = nums.length-1; i > 1; i--) {
            count+=twoSumGreater(nums, 0, i-1, nums[i]);
        }
        return count;
    }
    public int twoSumGreater(int[] numbers, int left, int right, int target) {
        int count = 0;
        while(left < right) {
            int ans = numbers[left] + numbers[right];
            if(ans > target) {
                count+=right-left;
                right--;
            }
            else {
                left++;
            }
        }
        return count;
    }
}
