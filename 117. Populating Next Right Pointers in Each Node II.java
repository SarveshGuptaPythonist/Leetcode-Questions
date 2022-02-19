
// It uses extra spaces
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            int count = q.size();
            for(int i=0; i<count; i++){
                Node curr = q.remove();
                
                // Populate Next Right Pointer of Curr
                if(i < count - 1) curr.next = q.peek();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        
        return root;
    }
}
