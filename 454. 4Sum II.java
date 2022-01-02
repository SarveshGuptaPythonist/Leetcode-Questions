class Solution {
    // class Pair{
    //     Pair(int a, int b) {
    //         this.a = a;
    //         this.b = b;
    //     }
    // }
    public List<List<Integer>> makePair(int[] arr1, int[] arr2) {
        // Pair[] pairs = new Pair[arr1.length * arr2.length];
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                List<Integer> curr = new ArrayList<>();
                curr.add(arr1[i]);
                curr.add(arr2[j]);
                res.add(curr);
            }
        }
        return res;
        
    }
    public HashMap<Integer, List<List<Integer>>> createMap(List<List<Integer>> pairs1) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for(List<Integer> pair: pairs1) {
            int sum1 = pair.get(0) + pair.get(1);
            if(map.containsKey(sum1)){
                map.get(sum1).add(pair);
            }
            else{
                List<List<Integer>> temp = new ArrayList<>();
                temp.add(pair);
                map.put(sum1, temp);
            }
        }
        return map;
    }
    
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        List<List<Integer>> pairs1 = makePair(nums1, nums2);
        List<List<Integer>> pairs2 = makePair(nums3, nums4);
        int ans = 0;
        
        HashMap<Integer, List<List<Integer>>> Map1 = createMap(pairs1);
        HashMap<Integer, List<List<Integer>>> Map2 = createMap(pairs2);
        for(Integer key1: Map1.keySet()) {
            int currTar = -key1;
            if(Map1.containsKey(key1) && Map2.containsKey(-key1)){
                ans += Map1.get(key1).size() * Map2.get(-key1).size();
            }
        }
        
        
        
        
        return ans;
    }
}
