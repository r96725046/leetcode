/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        
        int number=1;
        int[][] matrix=new int[n][n];
        int rowStart=0;
        int rowEnd=n-1;
        int colStart=0;
        int colEnd=n-1;

        while(rowStart<=rowEnd&&colStart<=colEnd){
            for(int j=colStart;j<=colEnd;j++){
                matrix[rowStart][j]=number++;
            }   
            rowStart++;
            for(int i=rowStart;i<=rowEnd;i++)
                matrix[i][colEnd]=number++;
            colEnd--;
            if(rowStart<=rowEnd){
                for(int j=colEnd;j>=colStart;j--)
                    matrix[rowEnd][j]=number++;
            }
            rowEnd--;
            if(colStart<=colEnd){
                for(int i=rowEnd;i>=rowStart;i--)
                    matrix[i][colStart]=number++;
            }
            colStart++;
        }

        return matrix;
    }
}
// @lc code=end

