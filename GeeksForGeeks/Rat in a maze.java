// Approach 1
// We have taken extra space for visited array therefore true and false as visited and m as array
class Solution {
    static ArrayList<String> res;
    public static void helper(int[][] m, boolean[][] vis, String str, int row, int col) {
        if(row >= m.length || row < 0 || col >= m.length || col < 0) {
            return;
        }
        
        if(m[row][col] == 0) return;// no path after this
        
        if(row == m.length-1 && col == m.length-1) {
            res.add(new String(str));
            return;
        }
        else{
            if(vis[row][col] == false && m[row][col] == 1) {
                vis[row][col] = true;
                helper(m, vis, str+"U", row-1, col);
                helper(m, vis, str+"D", row+1, col);
                helper(m, vis, str+"L", row  , col-1);
                helper(m, vis, str+"R", row  , col+1);
                vis[row][col] = false;
                
        }}
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean[][] vis = new boolean[n][n];
        
        
        
        res = new ArrayList<>();
        helper(m, vis, "", 0, 0);
        Collections.sort(res);
        return res;
        
    }
}
// Approach 2
// We will now take only 2d array and manipulate data in m rather than using vis array
