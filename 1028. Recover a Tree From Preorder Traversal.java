/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
  
class Solution {
    static final int COUNT = 10;
    
    // Wrapper over print2DUtil()
    static void print2d(TreeNode root)
    {
        // Pass initial space count as 0
        if(root == null) return;
        print2d(root.left);
        System.out.println(root.val);
        print2d(root.right);
    }

    public TreeNode createTree(int[] arr, int[] dashes) {
        TreeNode root = new TreeNode(arr[0]);
        int idx = 1;
        int curr = dashes[idx];
        int prev = dashes[idx-1];
        Stack<TreeNode> stk = new Stack();

        stk.push(root);
        // 1 2 3 4 5 6 7
        // 0 1 2 2 1 2 2
        while(stk.size() > 0 && arr[idx] > -1 && idx < 1001) {

            TreeNode stkpeek = stk.peek();
            
            curr = dashes[idx];
            prev = dashes[idx-1];
            if(curr > prev) {
                if(stkpeek.left == null) {
                    stkpeek.left = new TreeNode(arr[idx]);
                    stk.push(stkpeek.left);
                }
                else{
                    stkpeek.right = new TreeNode(arr[idx]);
                    stk.push(stkpeek.right);
                }
                
            }
            else if(curr == prev) {
                stk.pop();
                stkpeek = stk.peek();

                stkpeek.right = new TreeNode(arr[idx]);
                stk.push(stkpeek.right);
            }
            else if(curr < prev) {
                
                int ctr = prev - curr;
                while(ctr-- >= 0) {
                    stk.pop();
                    
                }
                stkpeek = stk.peek();
                if(stkpeek.left == null) {
                    stkpeek.left = new TreeNode(arr[idx]);
                    stk.push(stkpeek.left);
                }
                else{
                    stkpeek.right = new TreeNode(arr[idx]);
                    stk.push(stkpeek.right);
                }
            }
            idx++;
            
        }
        return root;
        
        
    }
    public TreeNode recoverFromPreorder(String trav) {
        int[] arr = new int[1001];
        int[] dashes = new int[1001];
        dashes[0] = 0;
        Arrays.fill(arr, -1);
        int adx = 0, ddx = 1;
        int i = 0;
        while(i < trav.length()) {
            int val = 0;
            int currDash = 0;
            while(i < trav.length() && trav.charAt(i) >= '0' && trav.charAt(i) <= '9') {
                
                val *= 10;
                val += (trav.charAt(i) - '0');
                
                i++;
            }
            
            if(val != 0) {
                arr[adx++] = val;
                continue;
            }
            
            while(i < trav.length() && trav.charAt(i) == '-') {
                
                currDash++;
                i++;
            }
            if(currDash != 0) {
                dashes[ddx++] = currDash;
                continue;
            }
            
            
        }
        
        return createTree(arr, dashes);
    }
}
// 1 2 3 4 5 6 7
// 0 1 2 3 1 2 3


// curr == prev+1
// curr == prev
// check for last 
//       1
//    2.            null
//  3.     null   null    4
// 5 null 6 null null 7
