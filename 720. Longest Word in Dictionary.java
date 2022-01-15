


class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(){
            isEnd = true;
        }
    }
    String res;
    public void insert(String word, Node root) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.contains(ch) == false)
                curr.set(ch);
        
            curr = curr.get(ch);
        }
        
        curr.setEnd();
    }
    public void dfs(Node curr,String str) {
        if(curr == null) return;
        
        if(str.length() > res.length()) {
            res =str;
        }
               
        
        for(char chn = 'a'; chn <= 'z'; chn++){
            if(curr.contains(chn) == false) continue;
            
            else if(curr.contains(chn) == true && curr.get(chn).getEnd() == true){
                 dfs(curr.get(chn), str + chn);
                
            }
            
        }
    }
    public String longestWord(String[] words) {
        res = "";
        Node root = new Node();
        for(String word: words) {
            insert(word, root);
        }
        dfs(root, "");
        return res;
    }
}









