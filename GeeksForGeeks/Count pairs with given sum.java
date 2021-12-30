class Solution {
    int getPairsCount(int[] arr, int n, int target) {
        // code here
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int comp = target - arr[i];
            int freq = map.getOrDefault(comp, 0);
            
            
            count += freq;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
