class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.get(ch) > 1) {
                char chl=s.charAt(left);
                map.put(chl, map.get(chl) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
        
