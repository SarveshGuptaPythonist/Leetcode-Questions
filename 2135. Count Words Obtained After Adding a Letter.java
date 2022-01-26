class Solution {
    
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch) {
            return (children[ch - 'a'] != null);
        }
        public Node get(char ch) {
            return children[ch - 'a'];
        }
        public void set(char ch) {
            children[ch - 'a'] = new Node();
        }
        public boolean getEnd(){
            return isEnd;
        }
        
        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }
    Node root;
    public void insert(Node root, String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                curr.set(ch);
            }
            curr = curr.get(ch);
        }
        curr.setEnd(true);
 
    }
    public boolean search(Node root, String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.contains(ch) == false) {
                return false;
            }
            curr = curr.get(ch);
        }
        return curr.getEnd();
    }
    
    public int wordCount(String[] startWords, String[] targetWords) {
        root = new Node();
        for(String word: startWords) {
            char charArray[] = word.toCharArray();
              Arrays.sort(charArray);
              String changed = new String(charArray);
            insert(root, changed);
        }
        int score = 0;
        for(int  i = 0; i < targetWords.length; i++) {
            for(int j = 0; j < targetWords[i].length(); j++) {
                String curr = targetWords[i].substring(0, j) + targetWords[i].substring(j+1); 
                char charArray[] = curr.toCharArray();
                Arrays.sort(charArray);
                String changed = new String(charArray);
                if(search(root, changed) == true) {
                    score++;
                    break;
                }
            }
        }
        return score;
        
    }
}













