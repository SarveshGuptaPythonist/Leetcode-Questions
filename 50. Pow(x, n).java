// https://leetcode.com/problems/powx-n/
class Solution {
    
    public double power(double x, long n) {
        if(n == 1) return x;
        if(n == 0) return 1.0;
        double res = power(x, n/2);
        if(n % 2 == 1){
            return res * res * x;
        }
        return res * res;
    }
    public double myPow(double x, int n) {
        
        
        if(n < 0){
            return 1.0 / power(x, -1l * n);
        }
        return power(x, n);
    }
}
