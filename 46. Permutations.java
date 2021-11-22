https://leetcode.com/problems/permutations/submissions/

class Solution {
    
    public void permuteHelper(List<List<Integer>> permutations, List<Integer> permutation,int[] nums,int curr, boolean[] items){
        if(curr == nums.length){
            List<Integer> res = new ArrayList<>(permutation);
            permutations.add(res);
            return;
        }
        for(int i= 0; i < nums.length; i++){
            if(items[i] == false){
                items[i] = true;
                permutation.add(nums[i]);
                permuteHelper(permutations, permutation, nums, curr+1, items);
                permutation.remove(permutation.size() - 1);
                items[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] items = new boolean[nums.length];
        
        permuteHelper(permutations, permutation, nums, 0, items);
        return permutations;
    }
}
