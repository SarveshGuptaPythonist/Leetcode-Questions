class GfG {
    int transitionPoint(int arr[], int n) {
        // code here
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i]==0) {
                count++;
            }
            else{
                break;
            }
        }
        if (count == n) return -1;
        return count;
    }
}
