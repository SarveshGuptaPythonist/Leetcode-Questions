class Solution {
    public int lowerBound(int[] arr, int target) {
        int left = 0; int right = arr.length-1;
        int ans = arr.length;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] >= target) {
                ans = mid;
                right = mid-1;
            }
            else{
                
                left = mid+1; 
            }
        }
        return ans;
    }
    public int[] sortedSquares(int[] nums) {
        
        int idx = lowerBound(nums, 0);
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int ptr1 = idx-1;int ptr2 = idx;
        int[] squared = new int[nums.length];
        
        for(int i = 0; i < squared.length; i++){
            int a = ptr1>=0 ? Math.abs(nums[ptr1]):Integer.MAX_VALUE;
            int b = ptr2<=nums.length-1 ? Math.abs(nums[ptr2]):Integer.MAX_VALUE;
            
            if(a <=b) {
                squared[i] = a;
                ptr1--;
            }
            else{
                squared[i] = b;
                ptr2++;
            }
        }
        return squared;
    }
}
