class Solution {
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int idx = search(nums, target);
        List<Integer> ans = new ArrayList<>();
        if(idx == -1) {
            return ans;
        }
        int min = idx;
        int max = idx;
        while(min-1 >= 0 && nums[min] == nums[min-1]) {
            min--;
        }
        while(max+1 < nums.length && nums[max] == nums[max+1]) {
            max++;
        }
        for(int j = min; j <= max; j++) {
            ans.add(j);
        }
        return ans;
    }
}
