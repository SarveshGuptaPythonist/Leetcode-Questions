class Solution {
    public int splitArray(int[] nums, int m) {
        return findPages(nums, m);
    }
    public static boolean isPossible(int[] arr, int studs, int mid) {
        int currStuds = 1;
        int currSum = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(currSum + arr[i] <= mid){
                currSum += arr[i];
            }
            else{
                currStuds++;
                currSum = arr[i];
            }
            
        }
        if(currStuds > studs) return false;
        return true;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[] arr, int studs)
    {
        //Your code here
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        int low = max, high = sum, ans = sum;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(arr, studs, mid) == true) {
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
                
            }
        }
        return ans;
    }
}


// This priblem is nothing but search books on answer which is to be found
