/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        
        if(n<=0)
            return 0;

        int[] dp=new int[n+1];

        for(int i=1;i<dp.length-1;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];

    }
}
// @lc code=end

