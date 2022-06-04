/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0)return 0;
        int[][][] dp =new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=1;j<k+1;j++){
                if(i==0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[i];
                }else{
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        return dp[prices.length-1][k][0];
    }
}
// @lc code=end

