class Solution {
    public int minInsertions(String s) {
        int open = 0, additions = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
            }
            else if(s.charAt(i) == ')') {
                
                if(open > 0) open--;
                else additions++;
                if(i + 1 < s.length() && s.charAt(i + 1) == ')') 
                    i++;
                
                else additions++;
            }
        }
        return additions + open * 2;
    }
}
