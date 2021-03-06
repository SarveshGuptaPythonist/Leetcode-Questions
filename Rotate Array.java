class Solution {
    public void swapIndexes(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--; 
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swapIndexes(nums, nums.length-k, nums.length-1);
        swapIndexes(nums, 0, nums.length-k-1);
        swapIndexes(nums, 0, nums.length - 1);
        
    }
}
