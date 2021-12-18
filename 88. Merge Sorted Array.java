class Solution {
    public void swap(int[] nums1, int a, int b) {
        int temp = nums1[a];
        nums1[a] = nums1[b];
        nums1[b] = temp;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        
        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        // Here it is [1 2 3 2 5 6]
        int ptr2 = m - n;
        for(int i = m; i < m+n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums1[j] > nums1[j + 1]) {
                    swap(nums1, j, j+1);
                }
                else{
                    break;
                }
            }
        }
        // return nums1;
    }
}
