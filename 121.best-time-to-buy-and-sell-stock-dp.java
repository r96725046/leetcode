/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][2];
        for(int i=0;i<prices.length;i++){
            if(i==0){
                dp[i][1][0]=0;
                dp[i][1][1]=-prices[i];
            }else{
                //no stock
                dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
                //has stock
                dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][0][0]-prices[i]);
            }
        }
        return dp[prices.length-1][1][0];
    }
}
// @lc code=end

