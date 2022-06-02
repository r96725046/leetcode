/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][3][2];
        for(int i=0;i<prices.length;i++){
            for(int k=1;k<3;k++){
                if(i==0){
                    dp[i][k][0]=0;
                    dp[i][k][1]=-prices[i];
                }else{
                    dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                    dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                }
            }
        }
        return dp[prices.length-1][2][0];
    }
}
// @lc code=end

