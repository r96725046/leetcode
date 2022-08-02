/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 */

// @lc code=start
class MagicDictionary {
    class Node{
        boolean isWord;
        Node[] nodes;
        public Node(){
            nodes=new Node[26];
        }        
    }
    Node root;
    public MagicDictionary() {
        root=new Node();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word:dictionary){
            Node cur=root;
            for(int i=0;i<word.length();i++){
                int v=word.charAt(i)-'a';
                if(cur.nodes[v]==null)
                    cur.nodes[v]=new Node();
                cur=cur.nodes[v];
            }
            cur.isWord=true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(searchWord,0,root,0);
    }
    public boolean dfs(String word,int index,Node root,int diff){
        if(index==word.length()){
            if(root.isWord&&diff==1)
                return true;
            return false;
        }
        char c=word.charAt(index);
        for(int i=0;i<root.nodes.length;i++){
            if(root.nodes[i]!=null){
                int d=diff;
                if((c-'a')!=i){
                    if(d==1)continue;
                    d++;
                }     
                if(dfs(word,index+1,root.nodes[i],d))
                    return true;
            }
        }
        return false;

    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
// @lc code=end

