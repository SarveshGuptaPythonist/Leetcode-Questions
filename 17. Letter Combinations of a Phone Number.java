class Solution {
    List<String> comb;
    public void combinationsHelper(String digits, String[] keypad, int idx, String res){
        if(idx == digits.length()){
            if(res.length() > 0) comb.add(res);
            return;
        }
        char digit = digits.charAt(idx);
        for(char letter: keypad[digit - '0'].toCharArray()) {
            combinationsHelper(digits, keypad, idx+1, res+letter);
        }
    }
    public List<String> letterCombinations(String digits) {
        comb = new ArrayList<>();
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        
        combinationsHelper(digits, keypad, 0, "");
        return comb;
    }
}
