/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
   
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int n:nums)
            sum+=n;
        if (target>sum || target < -sum){
            return 0;
        }
        int[][] dp=new int[nums.length+1][2*sum+1];
        dp[0][sum]=1;
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i-1][j]!=0){
                    dp[i][j+nums[i-1]]+=dp[i-1][j];
                    dp[i][j-nums[i-1]]+=dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][sum+target];
    }
   
   
}
// @lc code=end

