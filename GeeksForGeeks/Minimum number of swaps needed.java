public static long mergeSort(long[] nums, int left, int right){
        if(left >= right){
            return 0; // 0 or 1 elements in array
        }
        
        int mid = left + (right - left) / 2;
        long lans = mergeSort(nums, left, mid); // left Sorted
        long rans = mergeSort(nums, mid + 1, right); // right Sorted
        long mans = merge(nums, left, mid, mid + 1, right);
        return lans + rans + mans;
    }
    
    public static long merge(long[] nums, int a1l, int a1r, int a2l, int a2r){
        int totalRes = (a1r - a1l + 1) + (a2r - a2l + 1);
        long[] res = new long[totalRes];
        long invCount = 0;
        int ptr1 = a1l, ptr2 = a2l, ptr3 = 0;
        while(ptr1 <= a1r && ptr2 <= a2r){   
            if(nums[ptr1] <= nums[ptr2]){
                res[ptr3] = nums[ptr1];
                ptr3++; ptr1++;
            } 
            else {
                invCount += (a1r - ptr1 + 1L);
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
        return invCount;
    }

// There is an interesting solution to this problem. It can be solved using the fact that number of swaps needed is equal to number of inversions. 
// So we basically need to count inversions in array.
// The fact can be established using below observations: 
// 1) A sorted array has no inversions. 
// 2) An adjacent swap can reduce one inversion. Doing x adjacent swaps can reduce x inversions in an array. 
 
