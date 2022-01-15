/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> mainList;
    public List<TreeNode> helper(int n){
        if(n == 1) {
            TreeNode res = new TreeNode(0);
            List<TreeNode> tempList = new ArrayList<>();
            tempList.add(res);
            return tempList;
        }
        List<TreeNode> temp = new ArrayList<>();
        
        for(int i = 1; i <= n-2; i+=2) {
            List<TreeNode> left = helper(i);   
            List<TreeNode> right= helper(n - 1 - i);   
            
            for(TreeNode node1: left) {
                for (TreeNode node2 : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = node1;
                    root.right = node2;
                    
                    temp.add(root);
                }
            }
        }
        return temp;
        
        
    }
    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n);
    }
}
