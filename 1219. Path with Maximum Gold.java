class Solution {
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, -1, 1};
    public int DFS(int r, int c, int[][] grid) {
        
        if(r >= grid.length || c >= grid[0].length || c < 0 || r < 0 || grid[r][c] == 0 || grid[r][c] == -1) {
            return 0;
        }
        int val = grid[r][c];
        grid[r][c] = -1;
        int maxGold = 0;
        for(int i = 0; i < 4; i++) {
            maxGold = Math.max(DFS(r+x[i], c+y[i], grid), maxGold);
        }
        grid[r][c] = val;
        return val+maxGold;
        
        
    }
    public int getMaximumGold(int[][] grid) {
        
        int maxGold = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                maxGold = Math.max(maxGold, DFS(i, j, grid));
            }
        }
        return maxGold;
        
        
        
    }
}
