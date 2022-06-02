/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][][] dp=new int[prices.length][2][2];
        for(int i=0;i<prices.length;i++){
            if(i==0){
                dp[i][1][0]=0;
                dp[i][1][1]=-prices[0];
            }else{
                //keep or sell-fee
                dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]-fee);
                dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][1][0];
    }
}
// @lc code=end

