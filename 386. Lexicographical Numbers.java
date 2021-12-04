class Solution {
    List<Integer> res;
    public void Helper(int curr, int n) {
        if(curr > n) return;
        
        res.add(curr);
        curr *= 10;
        for(int i = 0; i < 10; i++) {
            curr += i;
            Helper(curr, n);
            curr -= i;
        }
        
        
    }
    public List<Integer> lexicalOrder(int n) {
     
        res = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            
            Helper(i, n);   
        }
        return res;
    }
}
