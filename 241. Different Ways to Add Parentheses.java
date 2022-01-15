class Solution {
    public int calc(int x, int y, char op) {
        if (op == '+') {
            return x + y;
        }
        if (op == '-') {
            return x - y;
        }
        
        return x* y;
    }
    public List<Integer> helper(String exp) {
        List<Integer> ans = new ArrayList<>();
        int opcount = 0;
        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch == '*' || ch == '-' || ch == '+') {
                List<Integer> left = helper(exp.substring(0, i));
                List<Integer> right = helper(exp.substring(i+1));
                char op = ch;
                for(Integer l : left) {
                    for (Integer r : right) {
                        ans.add(calc(l, r, op));
                    }
                }
                opcount++;
            }
        }
        if(opcount == 0) {
            ans.add(Integer.parseInt(exp));
        }
        
        return ans;
    }
    public List<Integer> diffWaysToCompute(String exp) {
        return helper(exp);
    }
}
