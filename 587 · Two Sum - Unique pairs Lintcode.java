public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        int left = 0, right = nums.length-1;
        int[] res = new int[2];
        int count = 0;
        while(left < right) {
            if(left - 1 > 0 && left < nums.length - 1 && nums[left] == nums[left-1]) left++;
            if(right - 1 > 0 && right < nums.length - 1 && nums[right] == nums[right+1]) right--;
            int ans = nums[left] + nums[right];
            if(ans == target) {
                // System.out.println(left + " " + right);
                left++;
                right--;
                count++;
                
            }
            else if(ans > target) {
                right--;
            }
            else{
                left++;
            }
        }
        return count;
    }
}
