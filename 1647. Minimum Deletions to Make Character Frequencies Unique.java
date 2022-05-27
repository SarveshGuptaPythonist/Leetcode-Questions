class Solution {
    public int getDistinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && set.contains(arr[i])) {
                return i;
            }
            else {
                set.add(arr[i]);
            }
        }
        return -1;
        
    }
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        int change = 0;
        int distinct = getDistinct(arr);
        while(distinct != -1) {
            arr[distinct]--;
            change++;
            distinct = getDistinct(arr);
        }
        return change;
    }
}
