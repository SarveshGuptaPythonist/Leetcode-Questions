class Solution {
    public int minSteps(String s, String t) {
        int[] schar = new int[26];
        int[] tchar = new int[26];
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            schar[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++) {
            tchar[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            count += Math.abs(schar[i] - tchar[i]);
        }
        return count;
    }
}
