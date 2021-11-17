class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(int i = 0; i < arr.length; i++)
            arr[i] = 0;
        
        for(int i = 0; i < s.length(); i++){ arr[s.charAt(i) - 'a']++; }
        for(int i = 0; i < t.length(); i++){ arr[t.charAt(i) - 'a']--; }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }
                
        return true;
        
    }
}

/*
  The main intuition here is to first add values in array by one, the array values shows the count of ascii value - 64 character, 
  Here values are added in same order and then decrerased in line 8, Lin 10 loop runs to check if any value is not 1 means the values of two stings are not same.
*/
