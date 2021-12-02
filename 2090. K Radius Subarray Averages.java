// Consiuce and optimized Solution

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (n < 2 * k + 1) {
            return res;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= 2 * k) {
                res[i - k] = (int) (sum / (2 * k + 1));
                sum -= nums[i - 2 * k];
            }
        }
        return res;
    }
}


// My solution
class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] res = new long[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            
            if((i + k) < nums.length && (i - k) > -1) {
                
                if(i==k){
                    for(int j = -k; j <= k; j++) {
                        res[i] += nums[i + j];
                    }
                }
                else{
                    res[i] = res[i-1] - nums[i-k-1] + nums[i+k];
                }
                
            }
            
            else {
                res[i] = -1;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            
            if(res[i] != -1) {
                res[i] /= (2*k+1);
            }
        }
        
        return Arrays.stream(res).mapToInt(i -> (int) i).toArray();
    }
}
