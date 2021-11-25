// incomplete for now

public class Solution {
    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
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
    List<List<Character>> res;
    public void permute(HashMap<Character, Integer> fmap, String str, int currBox, List<Character> ans, int count) {
        if(str.length() == count) {
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(Map.Entry<Character, Integer> entry: fmap.entrySet()){
            char ch = entry.getKey();
            if(fmap.get(ch) > 0) {
                if(fmap.get(ch) == 1){
                    fmap.put(ch, fmap.get(ch) - 1);
                    ans.add(ans.size()/2, ch);
                    permute(fmap, str, currBox+1, ans, count+1);
                    ans.remove(ans.size()/2);
                    fmap.put(ch, fmap.get(ch) + 1);
                }
                else{
                    fmap.put(ch, fmap.get(ch) - 2);
                    ans.add(currBox, ch);
                    ans.add(ans.size() - 1 - currBox, ch);
                    permute(fmap, str, currBox+1, ans, count+2);
                    ans.remove(currBox);
                    ans.remove(ans.size() - 1 - currBox);
                    fmap.put(ch, fmap.get(ch) + 2);
                }

            }
        }

        
    }
    public List<String> generatePalindromes(String s) {
        // write your code here
        if(canPermutePalindrome(s) == false){
            return new ArrayList<String>();
        }
        HashMap<Character, Integer> fmap = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
          if(fmap.containsKey(ch)){
            fmap.put(ch, fmap.get(ch) + 1);
          } else {
            fmap.put(ch, 1);
          }
        }
        res = new ArrayList<>();
        permute(fmap, s, 0, new ArrayList<>(), 0);
        List<String> finalRes = new ArrayList<>();
        System.out.println(res);
        for(int i = 0; i < res.size(); i++){
            finalRes.add("");
            for(int j = 0; j < res.get(i).size(); j++){
                finalRes.set(i, finalRes.get(i) + res.get(i).get(j));
            }
        }
        return finalRes;
    }
}




























