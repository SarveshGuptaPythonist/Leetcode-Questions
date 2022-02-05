class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> scoreStk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                scoreStk.push(-1); // put -1 to track and -1 will never be a score
            }
            else if(ch == ')') {
                int currScore = 0;
                if(scoreStk.peek() == -1) {
                    currScore++;
                    scoreStk.pop();
                }
                else{
                    while(scoreStk.peek() != -1) {
                        currScore += scoreStk.pop();
                    }
                    currScore *= 2;
                    scoreStk.pop();
                }
                scoreStk.push(currScore);
            }
        }
        int curr = 0;
        while(scoreStk.size() > 0) {
            curr += scoreStk.pop();
        } 
        return curr;
    }
}
