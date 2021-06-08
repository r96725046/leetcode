/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class TrieNode{

    TrieNode[] nodes;
    String word;
    public TrieNode(){
        nodes=new TrieNode[26];
        word="";
    }
    public void insert(String word){
        TrieNode runner=this;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(runner.nodes[idx]==null)
                runner.nodes[idx]=new TrieNode();
            if(i==word.length()-1)
                runner.nodes[idx].word=word;
            runner=runner.nodes[idx];
          
        }
    }

}
class Solution {
    // ****
    // words =>trie
    List<String> res=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        int[][] v=new int[board.length][board[0].length];
        for(int i=0;i<words.length;i++){
            root.insert(words[i]);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                    dfs(board,v,i,j,root);
            }
        }
        return res;

    }
    public void dfs(char[][] board,int[][] v,int i,int j,TrieNode node){


        if(i<0||j<0||i>=board.length||j>=board[0].length||v[i][j]==1)
            return;
        int index=board[i][j]-'a';
        TrieNode n=node.nodes[index]
        if(n==null)
            return;
        
        if(n.word!=""){
            res.add(n.word);
            n.word="";
        }
        v[i][j]=1;

        dfs(board,v,i+1,j,p);
        dfs(board,v,i,j+1,p);
        dfs(board,v,i-1,j,p);
        dfs(board,v,i,j-1,p);

        v[i][j]=0;

    }
}
// @lc code=end

