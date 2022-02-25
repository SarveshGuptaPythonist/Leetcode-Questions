// my solution
class Solution {
    public boolean helper(int n, int pow, int ans) {
        if(pow > 15 || n < 0 || n < ans) {
            return false;
        }
        if(n == ans) return true;
        
        int curr = (int)Math.pow(3, pow);
        boolean a =  helper(n, pow + 1, ans + curr);//curr power is added
        boolean b = helper(n, pow + 1, ans);// curr power is not added
        return a || b;
        
    }
    public boolean checkPowersOfThree(int n) {
        return helper(n, 0, 0);
    }
}
