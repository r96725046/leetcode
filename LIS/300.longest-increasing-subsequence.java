/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp=new int[nums.length];
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            dp[i]=1;
            for(int j=nums.length-1;j>=i;j--){
                if(nums[j]>nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
// @lc code=end

