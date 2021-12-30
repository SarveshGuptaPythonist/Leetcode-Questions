class Solution {
    public int maxOperations(int[] numbers, int k) {
        Arrays.sort(numbers);
        int left = 0, right = numbers.length-1;
        int[] res = new int[2];
        int count = 0;
        while(left < right) {
            int ans = numbers[left] + numbers[right];
            if(ans == k) {
                left++;
                right--;
                count++;
            }
            else if(ans > k) {
                right--;
            }
            else{
                left++;
            }
        }
        return count++;
    }
}
