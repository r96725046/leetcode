/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start

class WordDictionary {
    class Node{
        Node[] nodes;
        boolean isWord=false;
        public Node(){
            nodes=new Node[26];
        }
    }
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++){
            int v=word.charAt(i)-'a';
            if(cur.nodes[v]==null)
                cur.nodes[v]=new Node();
            cur=cur.nodes[v];
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {;
       return dfs(word,0,root);
    }
    public boolean dfs(String word,int index,Node root){
        if(index==word.length())
            return root.isWord;
        char c=word.charAt(index);
        if(c!='.'){
            if(root.nodes[c-'a']!=null)
                return dfs(word,index+1,root.nodes[c-'a']);
        }else{
            for(int i=0;i<root.nodes.length;i++){
                Node[] arr=root.nodes;
                if(arr[i]!=null){
                    if(dfs(word,index+1,arr[i]))
                        return true;
                }
            }

        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

