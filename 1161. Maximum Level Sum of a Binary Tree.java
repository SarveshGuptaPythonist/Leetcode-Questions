class Solution {
    int[] arr = new int[10001];
    int maxLevel = 0;
    public void dfs(TreeNode root, int level) {
        if(root == null) return;
        maxLevel = Math.max(maxLevel, level);
        arr[level] += root.val;
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    
    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);
        int max = Integer.MIN_VALUE, level = 0;
        for(int i = 1; i <= maxLevel; i++) {
            if(arr[i] > max) {
                max = arr[i];
                level = i;
            }
        }
        return level;
        
    }
}
