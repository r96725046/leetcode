/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    // ***
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] dp=new int[m][n];


        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1)
                    dp[i][j]=dungeon[i][j];
                else if(i==m-1)
                    dp[i][j]=Math.min(dungeon[i][j],dp[i][j+1]+dungeon[i][j]);
                else if(j==n-1)
                    dp[i][j]=Math.min(dungeon[i][j],dp[i+1][j]+dungeon[i][j]);
                else
                    dp[i][j]=Math.min(dungeon[i][j],Math.max(dp[i+1][j],dp[i][j+1])+dungeon[i][j]);
            }
        }

        return dp[0][0]>0?1:1-dp[0][0];
    }
}
// @lc code=end

