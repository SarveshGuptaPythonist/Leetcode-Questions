class Solution {
    
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];

        return helper(0, 0, m, n, grid, memo);
    }
    //     This method is done using memoization
    public int helper(int r, int c, int m, int n, int[][] grid, int[][] memo) {
        if(r == m || c == n) {
            return Integer.MAX_VALUE;
        }
        if(r == m-1 && c == n-1) return grid[r][c];
        if(memo[r][c] != 0) {
            return memo[r][c];
        }
        
        return memo[r][c] = grid[r][c] + Math.min(helper(r + 1, c, m, n, grid, memo), helper(r, c + 1, m, n, grid, memo));
    }
}
