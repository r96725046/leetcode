/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    // ***
    //1.at most number of coins, set arr=amount+1
    //2.if res=amount+1 return -1;
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        //as most number of coins
        for(int i=1;i<=amount;i++)dp[i]=amount+1;
        for(int i=0;i<=amount;i++)
        {
            for(int coin:coins){
                if(i-coin>=0){
                    dp[i]=Math.min(dp[i-coin]+1,dp[i]);
                }
            }

        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
// @lc code=end

