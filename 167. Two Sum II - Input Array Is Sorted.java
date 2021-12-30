class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] res = new int[2];
        while(left < right) {
            int ans = numbers[left] + numbers[right];
            if(ans == target) {
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }
            else if(ans > target) {
                right--;
            }
            else{
                left++;
            }
        }
        return res;
    }
}
