class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        long left = 1L;
        long right = x;
        long ans = 1L;
        while(left <= right) {
            long mid = left + (right-left)/2L;
            long square = mid * mid;
            if(square == x) {
                return (int)mid;
            }
            else if(square < x) {
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return (int)(ans);
    }
    public boolean isPerfectSquare(int num) {
        int x = mySqrt(num);
        if( x * x == num) return true;
        return false;
    }
}
