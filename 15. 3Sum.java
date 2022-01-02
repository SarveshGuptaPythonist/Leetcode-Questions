class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
            int currTar = target - nums[i];
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            while(left < right) {
                if(left > i+1 && nums[left] == nums[left-1]) {left++;continue;}
                int ans = nums[left] + nums[right];
                
                if(ans == currTar) {
                    // System.out.println(i + " " + left + " " + right);
                    List<Integer> currRes = new ArrayList<>();
                    currRes.add(nums[i]);
                    currRes.add(nums[left]);
                    currRes.add(nums[right]);
                    res.add(new ArrayList<>(currRes));
                    left++;
                    right--;
                    
                    
                }
                else if(ans > currTar){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return res;
    }
}
