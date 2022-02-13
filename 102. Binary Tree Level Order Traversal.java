class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> currRes = new ArrayList<>();
        while(queue.size() != 0) {
            currRes = new ArrayList();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                currRes.add(curr.val);
            }
            res.add(currRes);
        }
        return res;
    }
}
