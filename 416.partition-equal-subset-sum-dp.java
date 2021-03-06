/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {

        int sum=0;
        for(int v:nums)
            sum+=v;
        if(sum%2!=0)
            return false;

        sum=sum/2;
        boolean[][] dp=new boolean[nums.length+1][sum+1];

        for(int i=0;i<dp.length;i++)
            dp[i][0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<nums[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=(dp[i-1][j]||dp[i-1][j-nums[i-1]]);
            }
        }
        return dp[nums.length][sum];
    }
}
// @lc code=end

