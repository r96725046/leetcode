/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        

        int l=0;
        int r=matrix.length-1;
        int index=0;
        int mid=0;
        while(l<=r){

            mid=(l+r)/2;
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        if(mid>0)
            index=target>matrix[mid][0]?mid:mid-1;
        else
            index=0;
        
        l=0;
        r=matrix[0].length-1;
        while(l<=r){
             mid=(l+r)/2;
            if(matrix[index][mid]==target)return true;
            if(matrix[index][mid]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
}
// @lc code=end

