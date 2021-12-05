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
    int transitionPoint(int arr[], int n) {
        int left = 0; int right = n-1;
            int ans = -1;
            while(left <= right) {
                int mid = left + (right-left) / 2;
                if(arr[mid] == 0) {
                    left = mid+1;
                }
                else{
                    ans = mid;
                    right = mid-1;
                }
            }
            return ans;
    }
}
