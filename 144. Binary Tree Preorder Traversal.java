class Solution {
    List<Integer> res;
    public void preOrder(TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList();
        preOrder(root);
        return res;
    }
}
