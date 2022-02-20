class Tree
{
     
     public ArrayList<Integer> diagonal(Node root)
      {
           Queue<Node> q = new ArrayDeque<>();
           q.add(root);
           ArrayList<Integer> res = new ArrayList<>();
           Node curr = null;
           while(curr != null || q.size() > 0) {
               if(curr == null) {
                   curr = q.remove();
                   continue;
               }
               
               res.add(curr.data);
               if(curr.left != null) q.add(curr.left);
               curr = curr.right;
               
           }
           return res;
           
           
      }
}
