 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

// pre order

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

// inorder traversal
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

// post order
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
// level Order
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


//Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
    public TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> inorder, int inL, int inR, int preIdx) {
        if(inL > inR) return null;
        TreeNode curr = new TreeNode(preorder[preIdx]);
        int inIdx = inorder.get(preorder[preIdx]);
        
        curr.left = buildTree(preorder, inorder, inL, inIdx - 1, preIdx  + 1);
        curr.right = buildTree(preorder, inorder, inIdx + 1, inR, preIdx + 1 + (inIdx - inL));
        return curr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < inorder.length; i++) hm.put(inorder[i], i);
        return buildTree(preorder, hm, 0, inorder.length - 1, 0);
    }
}

// Construct Binary Tree from Inorder and Postorder Traversal
class Solution {
    public TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> inorder, int inL, int inR, int postIdx){
        if(inL > inR) return null;
        
        TreeNode curr = new TreeNode(postorder[postIdx]);
        int inIdx = inorder.get(postorder[postIdx]);
        
        curr.left = buildTree(postorder, inorder, inL, inIdx - 1, postIdx - 1 - (inR - inIdx));
        curr.right = buildTree(postorder, inorder, inIdx + 1, inR, postIdx - 1);
        return curr;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hm.put(inorder[i], i);
        
        return buildTree(postorder, hm, 0, inorder.length - 1, postorder.length - 1);
    }
}
// Construct Binary Tree from Preorder and Postorder Traversal
class Solution {
    public int find(int val, int[] postorder){
        for(int i=0; i<postorder.length; i++){
            if(postorder[i] == val) return i;
        }
        return -1;
    }

    public TreeNode construct(int[] preorder, int[] postorder, int prel, int prer,
                                int postl, int postr){
        if(prel > prer) return null;
        if(prel == prer) return new TreeNode(preorder[prel]);

        TreeNode root = new TreeNode(preorder[prel]);

        if(prel + 1 >= preorder.length) return root;

        int leftChild = preorder[prel + 1];
        int postIdx = find(leftChild, postorder);
        int leftCount = postIdx - postl + 1;
        root.left = construct(preorder, postorder, prel + 1, prel + leftCount, postl, postIdx);
        root.right = construct(preorder, postorder,  prel + leftCount + 1, prer, postIdx + 1, postr - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, postorder, 0, preorder.length - 1, 
                                             0, postorder.length - 1);
    }
}
