class Solution {
    int globalScore;
    public void caller(int[][] grid, boolean[][] vis,int i, int j, int dr, int dc, int score) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length) return;
        if(i == dr && j == dc){
            if(score == -1) globalScore++;
            
            return;
        }
        if(vis[i][j] == false && grid[i][j] !=-1) {
            vis[i][j] = true;
            caller(grid, vis, i+1, j, dr, dc, score-1);
            caller(grid, vis, i, j+1, dr, dc, score-1);
            caller(grid, vis, i-1, j, dr, dc, score-1);
            caller(grid, vis, i, j-1, dr, dc, score-1);
            vis[i][j] = false;
        }
    }
    public int uniquePathsIII(int[][] grid) {
        globalScore = 0;
        int score = grid.length * grid[0].length - 2;
        
        int[] src = new int[2];
        int[] dest = new int[2];
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++ ) {
            for(int j = 0; j < grid[0].length; j++) {
                int curr = grid[i][j];
                if(curr == -1) score--;
                if(curr == 1) {src[0] = i; src[1] = j;}
                if(curr == 2) {dest[0] = i; dest[1] = j;}
            }
        }
        caller(grid, vis, src[0], src[1], dest[0], dest[1], score);
        
        return globalScore;
    }
}
