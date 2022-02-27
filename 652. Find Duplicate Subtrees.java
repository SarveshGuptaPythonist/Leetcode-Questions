class Solution {
    HashMap<String, List<TreeNode>> res;
    public String dfs(TreeNode curr) {// yeh ek serialization process hai basic, value = value, null = #
        if(curr == null) return "#";
        String ans = Integer.toString(curr.val) + "," + dfs(curr.left) + "," + dfs(curr.right);
        if(res.containsKey(ans) == false) {// agar pehle se aisa string ho toh woh already hai, yaani humne duplicate find kiya hai
            List<TreeNode> temp = new ArrayList();
            res.put(ans, temp);// agar nahi toh hum ek aur list add kr denge
        }
        res.get(ans).add(curr);
        return ans;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new HashMap();// hashmap map mai duplicate value aur list hogi nodes ki, agar 1 se zyada hui toh wahi duplicates hai
        String ans = dfs(root);
        List<TreeNode> finalAns = new ArrayList();
        for (String name : res.keySet())// this is basic looping 
        {
            // search  for value
            List<TreeNode> curr = res.get(name);
            if(curr.size() > 1) {
                finalAns.add(curr.get(0));
            }
        }
        return finalAns;
        
    }
}
