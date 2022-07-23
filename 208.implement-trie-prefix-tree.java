/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start

class Trie {
    // *** 
    //boolean isWord
    class Node{
        Node[] nodes;
        boolean isWord;
        public Node()
        {
            nodes=new Node[26];
        }
    }
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++){
            int v=word.charAt(i)-'a';
            if(cur.nodes[v]==null)
                cur.nodes[v]=new Node();
            cur=cur.nodes[v];
        }
        cur.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++){
            int v=word.charAt(i)-'a';
            if(cur.nodes[v]==null)
                return false;
            cur=cur.nodes[v];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            int v=prefix.charAt(i)-'a';
            if(cur.nodes[v]==null)
                return false;
            cur=cur.nodes[v];
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

