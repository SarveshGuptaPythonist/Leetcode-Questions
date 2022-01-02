public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int  left = 0, right = 1;
        while(left != nums.length && right != nums.length) {
            if(left == right) {
                if(target < 0) left++;
                else right++;
                continue;
            }
            int diff = nums[right] - nums[left];
            if(diff == target) {
                int[] a = {nums[right], nums[left]};
                Arrays.sort(a);
                return a;
            }
            else if(diff < target) {
                right++;
            }
            else{
                left++;
            }


        }
        return null;
    }
}
