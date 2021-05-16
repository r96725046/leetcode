/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] m=new int[board.length][board[0].length];
        char c=word.charAt(0);
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++){
                if(c==board[i][j]&&dfs(i,j,m,board,word,0))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,int[][] m,char[][] board,String word,int index){
        if(index==word.length())return true;

        if(i<0||i>=board.length||j<0||j>=board[0].length)
            return false;
        if(board[i][j]!=word.charAt(index))return false;
        if(m[i][j]==1)return false;
        m[i][j]=1;
        
        boolean res= dfs(i+1,j,m,board,word,index+1)||
               dfs(i-1,j,m,board,word,index+1)||
               dfs(i,j+1,m,board,word,index+1)||
               dfs(i,j-1,m,board,word,index+1);
        
        if(!res)
            m[i][j]=0;

        return res;
    }
}
// @lc code=end

