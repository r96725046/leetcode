/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length+1][matrix[0].length+1];

        //1.One of this cell's neighbor is 0, then this cell will be 0
        //2.User matrix i+1,j+1
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                if(matrix[i][j]=='0')
                    dp[i+1][j+1]=0;
                else
                    dp[i+1][j+1]=Math.min(dp[i][j], Math.min(dp[i][j+1],dp[i+1][j]))+1;
                if(dp[i+1][j+1]>max)
                    max=dp[i+1][j+1];
            }

        }

        return max*max;
    }
}
// @lc code=end

