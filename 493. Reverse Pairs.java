class Solution {
    public int mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return 0; // 0 or 1 elements in array
        }

        int mid = left + (right - left) / 2;
        int lans = mergeSort(nums, left, mid); // left Sorted
        int rans = mergeSort(nums, mid + 1, right); // right Sorted
        int mans = merge(nums, left, mid, mid + 1, right);
        return lans + rans + mans;
    }

    public int merge(int[] nums, int a1l, int a1r, int a2l, int a2r){
        int totalRes = (a1r - a1l + 1) + (a2r - a2l + 1);
        int[] res = new int[totalRes];
        int totalCount = 0;
        int ptr1 = a1l, ptr2 = a2l, ptr3 = 0;
        // Here we have run code to first find reverse Pairs, The Other Code after while is Just 
        // merge 2 sorted array code.         
        while(ptr1 <= a1r && ptr2 <= a2r){   
            if((long)nums[ptr1] <= 2L * (long)nums[ptr2]){
                res[ptr3] = nums[ptr1];
                ptr3++; ptr1++;
            } 
            else {
                totalCount += (a1r - ptr1 + 1); 
                res[ptr3] = nums[ptr2];
                ptr3++; ptr2++;
            }
        }
        ptr1 = a1l; ptr2 = a2l; ptr3 = 0;
        while(ptr1 <= a1r && ptr2 <= a2r){   
            if(nums[ptr1] <= nums[ptr2]){
                res[ptr3] = nums[ptr1];
                ptr3++; ptr1++;
            } 
            else {
                res[ptr3] = nums[ptr2];
                ptr3++; ptr2++;
            }
        }

        while(ptr1 <= a1r){
           res[ptr3] = nums[ptr1];
           ptr3++; ptr1++; 
        }

        while(ptr2 <= a2r){
           res[ptr3] = nums[ptr2];
           ptr3++; ptr2++;  
        }

        for(int i=a1l; i<=a2r; i++){
            nums[i] = res[i - a1l];
        }
        return totalCount;
    }
    public int reversePairs(int[] nums) {
        int ans = mergeSort(nums, 0, nums.length-1);
        return ans;
    }
}
// We cant do nums[i] > 2 * nums[j] operation and our while merge array, Because of our algo of running while algo, Only one condtition can be satisfied.
