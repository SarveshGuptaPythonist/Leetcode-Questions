class Solution {
    public boolean validPalindrome(String s) {
        
        int i = 0, j = s.length() - 1;
        while(i < j) {
            char left = s.charAt(i), right = s.charAt(j);
            if(left == right) {
                i++;
                j--;
            }
            else {
                return validPalindrome(s, i+1, j) || validPalindrome(s, i, j-1); 
            }
        } 
        return true;
    }
    public boolean validPalindrome(String s, int i, int j) {
        
        
        while(i < j) {
            char left = s.charAt(i), right = s.charAt(j);
            if(left == right) {
                i++;
                j--;
            }
            else {
                return false;
            }
        } 
        return true;
    }
    
}
