class Solution {
    //               result in string, Balanced Count     
    public void Helper(String strRes, int BalCount, int total) {
        if(BalCount < 0 || BalCount > total || strRes.length() > 2 * total) {// if n = 3 and BalCount is 4 it means (((( - something like this
            return;
        }
        if(BalCount == 0 && strRes.length() == 2 * total) {
            res.add(strRes);
            return;
        }
        
        Helper(strRes + '(', BalCount + 1, total);
        Helper(strRes + ')', BalCount - 1, total);
        
    }
    List<String> res;
    public List<String> generateParenthesis(int n) {
        
        
        res = new ArrayList<>();
        Helper("", 0, n);
        return res;
        
    }
}
// First If - We can have value less than 0 -> ())
// Second   - We can have value greater than n -> (((((
// Third    - We can have value balancing like -> ()()()() - These are stable/Balanced but thier count is greater than n so return

// Second If - is the base condition - Where if BalcCount == 0 means balanced and Length of result is also twice of n so return;
// Reverrse Call Just Do a Call for Brackets
