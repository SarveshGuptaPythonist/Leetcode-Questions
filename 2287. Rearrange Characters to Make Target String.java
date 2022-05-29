class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sArr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
        }
        int[] tarArr = new int[26];
        for(int i = 0; i < target.length(); i++) {
            tarArr[target.charAt(i) - 'a']++;
        }
        boolean cond = true;
        int count = 0;
        while (cond==true) {
            for(int i = 0; i < 26; i++) {
                if(sArr[i] >= tarArr[i]) {
                    sArr[i] -= tarArr[i];
                }
                else {
                    return count;
                }
            }
            count++;
        }
        return count;
    }
}
