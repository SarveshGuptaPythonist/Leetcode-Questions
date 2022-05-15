class Solution {
    // memoization
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
    // tabulation - n * m space
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // tabulation
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int i = m-1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m-1  && j == n - 1){
                    continue;
                }
                dp[i][j] = Math.min(
                    (i + 1 == m ? Integer.MAX_VALUE:dp[i+1][j]), 
                    (j + 1 == n ? Integer.MAX_VALUE:dp[i][j+1])
                ) + grid[i][j];
                
            }
        }
        return dp[0][0];
    }
    // tabulation using 2d dp
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] dp = new int[n];
        for(int j = 0; j < dp.length; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        
        for(int i = m-1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m-1  && j == n - 1){
                    dp[j] = grid[i][j];
                    continue;
                }
                dp[j] = Math.min(
                    (dp[j]), 
                    (j + 1 == n ? Integer.MAX_VALUE:dp[j+1])
                ) + grid[i][j];
                
            }
        }
        return dp[0];
    }
}
