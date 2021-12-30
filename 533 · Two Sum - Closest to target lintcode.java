public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] numbers, int target) {
        // write your code here'
        Arrays.sort(numbers);
        int left = 0, right = numbers.length-1;
        // int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        while(left < right) {
            int ans = numbers[left] + numbers[right];
            if(ans == target) {
                // res[0] = left+1;
                // res[1] = right+1;
                // min = Math.min(target, ta)
                return 0;
                // return res;
            }
            else if(ans > target) {
                min = Math.min(min, Math.abs(target - (numbers[left] + numbers[right])));
                right--;
            }
            else{
                min = Math.min(min, Math.abs(target - (numbers[left] + numbers[right])));
                left++;
            }
        }
        return min;
    }
}
