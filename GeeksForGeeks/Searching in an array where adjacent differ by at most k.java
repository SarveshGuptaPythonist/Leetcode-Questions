class Complete{
    
   
    // Function for finding maximum and value pair
    public static int search (int arr[], int n, int target, int k) {
        //Complete the function
        int idx = 0;
        while(idx < n) {
            if(arr[idx] == target) return idx;
            int minJump = (Math.abs(target - arr[idx])) / k;
            if(minJump == 0) minJump++;
            idx = idx+ minJump;
        }
        return -1;
    }
    
    
}


