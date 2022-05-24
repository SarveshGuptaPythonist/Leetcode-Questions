class Solution {
    public int longestMountain(int[] nums) {
        int max = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            // potential peak element
            if(i > 0 && i < nums.length-1 && nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                int curr = 0;
                int left =  i-1;
                while(left >=0  && nums[left] < nums[left+1]) {
                    left--;curr++;
                }
                int right = i+1;
                while(right < nums.length && nums[right-1] > nums[right]){
                    right++;curr++;
                }
                max= Math.max(max, curr+1);
            }
        }
        return max;
    }
}
// here we will first ask from element if it is peak, 
// if it comes out to be peak, we go one by one to its left and right and add curr on particular condition line 11 and line 15. 
// Now we will just take max and add current.
