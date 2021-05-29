/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    //Start from 0,matrix[0].length-1
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int i=0;
        int j=matrix[0].length-1;

        while(i<matrix.length&&j>=0){

            if(matrix[i][j]==target)
                return true;
            else if(target<matrix[i][j])
                j--;
            else 
                i++;
        }

        return false;
        
    }
}
// @lc code=end

