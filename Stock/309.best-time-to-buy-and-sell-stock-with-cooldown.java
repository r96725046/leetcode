/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][2];
        for(int i=0;i<prices.length;i++){
            if(i==0){
                dp[i][1][0]=0;
                dp[i][1][1]=-prices[i];
            }else if(i==1){   
                //hold or sell
                dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
                //hold or buy
                dp[i][1][1]=Math.max(dp[i-1][1][1],-prices[i]);
            }else{
                dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);
                dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-2][1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][1][0];
    }
}
// @lc code=end

