/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Node{
        int L=26;
        Node[] arr;
        boolean isWord;
        public Node()
        {
            arr=new Node[L];
        }
}
class Trie {
    // *** 
    //boolean isWord
    Node head;
    /** Initialize your data structure here. */
    public Trie() {
        head=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
            Node cur=head;
            for(int i=0;i<word.length();i++){
                int id=word.charAt(i)-'a';
                if(cur.arr[id]==null){
                    Node n=new Node();
                    cur.arr[id]=n;
                }
                cur=cur.arr[id];
            }
            cur.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=head;
        
        for(int i=0;i<word.length();i++){
            int id=word.charAt(i)-'a';
            if(cur.arr[id]==null)
                return false;
            cur=cur.arr[id];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node[] cur=head.arr;
        for(int i=0;i<prefix.length();i++){
            
            int id=prefix.charAt(i)-'a';
            if(cur[id]==null)
                return false;
            else
                cur=cur[id].arr;
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
 // @lc code=end

