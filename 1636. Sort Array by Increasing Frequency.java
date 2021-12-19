class Solution {
    public int[] frequencySort(int[] s) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length ; i++) {
            freq.put(s[i], freq.getOrDefault(s[i], 0) + 1);
        }
        
        TreeSet<Integer>[] buckets = new TreeSet[s.length + 1];
        for(int i =0; i < buckets.length; i++) {
            buckets[i] = new TreeSet<>();
            
        }
        
        for(Integer ch: freq.keySet()) {
            
            int val = freq.get(ch);
            buckets[val].add(ch);
        }
        
        int[] res = new int[s.length];
        int idx = 0;
        
        for(int b = 0; b < buckets.length; b++) {
            for(Integer ch: buckets[b].descendingSet()) {
                for(int f = 0; f < b; f++) {
                    res[idx++] = ch;
                }
            }
        }
        return res;
    }
}
