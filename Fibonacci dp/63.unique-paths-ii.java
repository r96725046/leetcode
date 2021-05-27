/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */
/*
62. Unuque Paths
91. Decode Ways
70. Climbing Stairs
509. Fibonacci Number
*/
// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        int[][] grid=obstacleGrid;

        if(grid[0][0]==1)
            return 0;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i==1&&j==1)
                    dp[i][j]=1;
                else if(grid[i-1][j-1]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    
                }
            }

        }
        return dp[dp.length-1][dp[0].length-1];

    }
}
// @lc code=end

