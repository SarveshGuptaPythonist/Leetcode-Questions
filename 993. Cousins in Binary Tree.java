// xLevel == yLevel (Not sibling not cousin)
// xPar.val == yPar.val(siblings not cousin)
// xLevel == yLevel && xPar.val != yPar.val(same level different cousins)
class Solution {
    TreeNode xPar, yPar;
    int xLevel, yLevel;
    
    public void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {
        if(root == null) return;
        int val = root.val;
        if(val == x) {
            xLevel = level;
            xPar = parent;
        }
        if(val == y) {
            yLevel = level;
            yPar = parent;
        }
        dfs(root.left, root, level + 1, x, y);
        dfs(root.right, root, level + 1, x, y);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        xPar = yPar = new TreeNode(-1);
        dfs(root, xPar, 0, x, y);
        if(xLevel == yLevel && xPar.val != yPar.val) {
            return true;
        }
        return false;
    }
}
