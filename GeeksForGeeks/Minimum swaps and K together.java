class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        int slot = 0;
        for(int i = 0; i< n; i++) {
            if(arr[i] <= k) {
                slot += 1;
            }
        }
        
        int maxInSlot = Integer.MIN_VALUE;
        int moreThanK = 0;
        
        for(int i = 0; i < slot; i++) {
            if(arr[i] > k) {
                moreThanK++;
            }
        }
        int minSwap = moreThanK;
        for(int i = slot; i < n; i++) {
            if(arr[i] > k) moreThanK++;
            if(arr[i-slot] > k) moreThanK--;
            minSwap = Math.min(minSwap, moreThanK);
        }
        return minSwap;
        
    }
    
    
}
