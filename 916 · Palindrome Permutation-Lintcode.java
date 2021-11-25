public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        char[] charArr = new char[26];
        for(int i = 0; i < s.length(); i++){
            charArr[s.charAt(i) - 'a']++;
        }
        boolean oddBoolean = false;
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] %2 == 1){
                if(oddBoolean == false)
                    oddBoolean = true;
                else{
                    return false;
                }
            }
        }
        return true;

    }
}
