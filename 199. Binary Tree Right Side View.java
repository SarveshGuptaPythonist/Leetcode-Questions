// using bfs
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> currRes = new ArrayList<>();
        List<Integer> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() != 0) {
            currRes = new ArrayList();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                currRes.add(curr.val);
            }
            ans.add(currRes.get(currRes.size() - 1));
        }
        
        return ans;
    }
}
