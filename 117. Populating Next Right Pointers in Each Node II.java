
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
// this is using no extra space
class Solution {
    public Node connect(Node root) {
        Node curr = root;
        while(curr != null) {
            Node head = null, tail = null;
            
            while(curr != null) {
                
                if(curr.left != null) {
                    if(head == null) {
                        head = tail = curr.left;
                        
                    }
                    else{ 
                        tail.next = curr.left;
                        tail = tail.next;
                    }
                }
                if(curr.right != null) {
                    
                    if(head == null) {
                        head = tail = curr.right;
                        
                    }
                    else{ 
                        tail.next = curr.right;
                        tail = tail.next;
                    }
                }
                
                curr = curr.next;
            }
            
            curr = head;
        }
        return root;
        
    }
}
