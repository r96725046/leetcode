/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] sum=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0)
                    sum[i][j]=matrix[i][j];
                else{
                    int l=sum[i-1][Math.max(0,j-1)];
                    int mid=sum[i-1][j];
                    int r=sum[i-1][Math.min(matrix[0].length-1,j+1)];
                    sum[i][j]=Math.min(Math.min(l,r),mid)+matrix[i][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<matrix[0].length;j++){
            min=Math.min(min,sum[matrix.length-1][j]);
        }
        return min;
    }
}
// @lc code=end

