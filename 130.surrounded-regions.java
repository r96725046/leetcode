/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        //1.Use #
        //2.Run from 4 edges

        for(int i=0;i<board.length;i++ ){

            for(int j=0;j<board[0].length;j++)
            {
                if(i==0||j==0||i==board.length-1||j==board[0].length-1){
                    if(board[i][j]=='O')
                        dfs(board,i,j);
                }
            }

        }
        for(int i=0;i<board.length;i++ ){

            for(int j=0;j<board[0].length;j++)
            {
                 if(board[i][j]=='O')
                    board[i][j]='X';
                if(board[i][j]=='#')
                    board[i][j]='O';
               
            }

        }

    }

    public void dfs(char[][] board,int i,int j){
        
        if(i<0||j<0||i>board.length-1||j>board[0].length-1||board[i][j]=='#')
            return;
        if(board[i][j]=='O'){
            board[i][j]='#';
            dfs(board,i+1,j);
            dfs(board,i,j+1);
            dfs(board,i-1,j);
            dfs(board,i,j-1);
        }
        return;
    }
}
// @lc code=end

