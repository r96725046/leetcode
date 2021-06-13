/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        // **
        // first row and first column as index
        // 1. fr fc
        // 2. i,j start from 1. set index to 0
        // 3. i,j start from 1. if index = 0, set ij=0
        // 4. if fr fc, set first row/col to 0
        boolean fr=false;
        boolean fc=false;

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0)
                fc=true;
        }
        for(int j=0;j<matrix[0].length;j++)
        {
            if(matrix[0][j]==0)
                fr=true;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[0][j]==0||matrix[i][0]==0)
                    matrix[i][j]=0;
            }
        }
        if(fc){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0]=0;
        }
        if(fr){
            for(int j=0;j<matrix[0].length;j++)
                matrix[0][j]=0;
        }    
    }    
}
// @lc code=end

