class Solution {
    List<Integer> res;
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList();
        inOrder(root);
        return res;
    }
}
