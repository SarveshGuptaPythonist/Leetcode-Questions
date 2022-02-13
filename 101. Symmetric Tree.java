class Solution {
    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        
        if(left.val == right.val) {
            boolean h1 = helper(left.left, right.right);
            boolean h2 = helper(left.right, right.left);
            return (h1 && h2);
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
}
