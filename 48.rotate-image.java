/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    // **
    // 1. i,j & j,i ,end++
    // 2.swap left and right
    public void rotate(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
           for(int j=i;j<col;j++)
               swap(matrix,i,j,j,i);
           
        for(int i=0;i<row;i++)
            for(int j=0;j<col/2;j++)
                swap(matrix,i,j,i,col-j-1);
    }
    public void swap(int[][] matrix,int i,int j,int x,int y){
        int tmp=matrix[i][j];
        matrix[i][j]=matrix[x][y];
        matrix[x][y]=tmp;
    }
}
// @lc code=end

