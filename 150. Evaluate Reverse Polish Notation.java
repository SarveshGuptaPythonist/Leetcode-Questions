class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack();
        for(String token: tokens) {
            if(token.equals("+")) {
                int a = stk.pop();
                int b = stk.pop();
                stk.push((b+a));
            }
            else if(token.equals("-")) {
                int a = stk.pop();
                int b = stk.pop();
                stk.push((b-a));
            }
            else if(token.equals("*")) {
                int a = stk.pop();
                int b = stk.pop();
                stk.push((b*a));
            }
            else if(token.equals("/")) {
                int a = stk.pop();
                int b = stk.pop();
                stk.push((b/a));
            }
            else  {
                stk.push(Integer.parseInt(token));
            }
        }
        return stk.pop();
    }
}
