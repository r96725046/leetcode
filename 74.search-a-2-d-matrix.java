/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    //Start from 0,matrix[0].length-1
    //O(log(m+n))
    //O(mn)
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int l=0;
        int r=matrix.length*matrix[0].length-1;
        int col=matrix[0].length;
        while(l<=r){
            int mid=l+(r-l)/2;
            int v=matrix[mid/col][mid%col];
            if(v==target)
                return true;
            else if(v>target)
                r=mid-1;
            else 
                l=mid+1;
        }

        return false;
        
    }
}
// @lc code=end

