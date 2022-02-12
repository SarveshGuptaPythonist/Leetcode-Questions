class Solution {
    List<Integer> res;
    public void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
        
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList();
        postOrder(root);
        return res;
    }
}
