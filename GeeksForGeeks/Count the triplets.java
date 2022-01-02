class Solution {
    public int twoSum(int[] numbers, int left, int right, int target) {
        int count = 0;
        while(left < right) {
            int ans = numbers[left] + numbers[right];
            if(ans == target) {
                count++;
                left++;
                right--;
            }
            else if(ans > target) {
                right--;
            }
            else{
                left++;
            }
        }
        return count;
    }
    int countTriplet(int arr[], int n) {
        // code here
        int count = 0;
        Arrays.sort(arr);
        for(int i = arr.length-1; i > 1; i--) {
            int target = arr[i];
            int left = 0;
            int right = i - 1;
            count += twoSum(arr, left, right, target);
        }
        return count;
    }
}
