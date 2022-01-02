class Solution {
    public List<List<Integer>> twoSum(int[] nums, int left, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int right = nums.length-1;
        int start = left;
        while(left < right) {
            if(left > start && nums[left-1] == nums[left]) {
                left++; continue;
            }
            int sum = nums[left] + nums[right];
            
            if(sum == target) {
                    // System.out.println(i + " " + left + " " + right);
                    List<Integer> currRes = new ArrayList<>();
                    currRes.add(nums[left]);
                    currRes.add(nums[right]);
                    ans.add(new ArrayList<>(currRes));
                    left++;
                    right--;
                    
                    
                }
                else if(sum > target){
                    right--;
                }
                else{
                    left++;
                }
        }
        return ans;
    }
    public List<List<Integer>> kSum(int[] nums,int start, int target, int k) {
        if(k == 2) {
            return twoSum(nums, start, target);
        }
        List<List<Integer>> res= new ArrayList<>();
        for(int i = start; i <= nums.length-k; i++) {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            List<List<Integer>> subRes = kSum(nums, i+1, target-nums[i], k-1);
            for(List<Integer> sub: subRes) {
                sub.add(0, nums[i]);
                res.add(sub);
            }
        }
        return res;
        
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
}
