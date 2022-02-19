class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        ArrayList<Integer> currRes = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() != 0) {
            currRes = new ArrayList();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node curr = queue.remove();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                currRes.add(curr.data);
            }
            ans.add(currRes.get(0));
        }
        
        return ans;
    }
}
