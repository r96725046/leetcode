/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    // ****
    // k='1'
    // row 1-9 col 1-9 cell 1-9
    // row=(i/3)*3
    // col=(j=/3)*3
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    private boolean solve(char[][] board,int i,int j){
        if(i==9)return true;
        if(j==9)return solve(board,i+1,0);
        if(board[i][j]!='.')return solve(board,i,j+1);
        for(char k='1';k<='9';k++){
            if(valid(board,i,j,k)){
                board[i][j]=k;
                if(solve(board,i,j+1))return true;
                board[i][j]='.';
            }
        }
        return false;
    }
    private boolean valid(char[][] board,int i,int j,char val){
        for(int col=0;col<9;col++)
            if(board[i][col]==val)return false;
        for(int row=0;row<9;row++)
            if(board[row][j]==val)return false;

        int row=(i/3)*3;
        int col=(j/3)*3;
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if(board[row+x][col+y]==val)return false;
            }
        }
        return true;
    
    }
}
// @lc code=end

