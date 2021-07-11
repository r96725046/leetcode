/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    // ***
    // hashset 1.row 2.col 3.cell 
    // cell =>i/3 , j/3
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set=new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    String v="#"+board[i][j]+"#";
                    String row=i+v;
                    String col=v+j;
                    String cell=i/3+v+j/3;
                    if(set.contains(row)||set.contains(col)||set.contains(cell))return false;
                    set.add(row);
                    set.add(col);
                    set.add(cell);
                }
            }
        }
        return true;
    }
}
// @lc code=end

