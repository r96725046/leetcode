/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class TrieNode{

    TrieNode[] nodes;
    boolean isWord=false;
    public TrieNode(){
        nodes=new TrieNode[26];
    }

}
class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode runner=root;
        for(int i=0;i<word.length();i++){

            int v=word.charAt(i)-'a';
            if(runner.nodes[v]==null)
                runner.nodes[v]=new TrieNode();
            if(i==word.length()-1)
                runner.nodes[v].isWord=true;
            runner=runner.nodes[v];
        }

    }
    
    public boolean search(String word) {
       TrieNode runner=root;
       return dfs(word,0,runner);
    }
    public boolean dfs(String word,int index,TrieNode node){

        if(index==word.length()){
            return node.isWord;
        }else{
            char c=word.charAt(index);
            if(c=='.'){
                
                for(int i=0;i<node.nodes.length;i++)
                {
                    if(node.nodes[i]!=null&&dfs(word,index+1,node.nodes[i]))
                        return true;
                }
                return false;
            }else{
                int v=c-'a';
                if(node.nodes[v]==null)
                    return false;
                else
                    return dfs(word,index+1,node.nodes[v]);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

