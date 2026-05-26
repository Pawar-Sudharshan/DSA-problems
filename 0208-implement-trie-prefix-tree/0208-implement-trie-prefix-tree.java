class Node{
    Node[] child ;
    boolean isEnd;
    public Node(){
        child =new Node[26];
        isEnd=false;
    }
}
class Trie {
    Node node;
    public Trie() {
        node = new Node();
    }
    
    public void insert(String word) {
       Node  temp= node;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(temp.child[idx] == null)
                temp.child[idx] = new Node();
            temp = temp.child[idx];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = node;
        for(char ch : word.toCharArray()){
            int idx = ch -'a';
            if(temp.child[idx] == null) return false;
            temp = temp.child[idx];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = node;
        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            if(temp.child[idx] == null) return false;
            temp = temp.child[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */