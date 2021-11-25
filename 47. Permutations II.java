class Solution {
    List<List<Integer>> res;
    public void permute(HashMap<Integer, Integer> fmap, int[] nums, int currBox, List<Integer> ans) {
        if(nums.length == currBox){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(Map.Entry<Integer, Integer> entry: fmap.entrySet()){
            int ch = entry.getKey();
            if(fmap.get(ch) > 0) {

                fmap.put(ch, fmap.get(ch) - 1);
                ans.add(ch);
                permute(fmap, nums, currBox+1, ans);
                ans.remove(ans.size() - 1);
                fmap.put(ch, fmap.get(ch) + 1);

            }
        }
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(Integer ch: nums){
          if(fmap.containsKey(ch)){
            fmap.put(ch, fmap.get(ch) + 1);
          } else {
            fmap.put(ch, 1);
          }
        }
        res = new ArrayList<>();
        permute(fmap, nums, 0, new ArrayList<>());
        
        return res;
    }
}
