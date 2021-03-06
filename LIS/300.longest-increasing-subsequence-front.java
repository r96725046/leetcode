/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    // ***
    // n^2 dp
    // nlogn
    // 1.start from 1
    // 2.loop compare if num[i]>num[j]
    //   max(nun[j]+1,nums[i])
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int max=1;
        for(int i=0;i<nums.length;i++){
           dp[i]=1;
           for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
           }
           max=Math.max(max,dp[i]);
        }
        return max;
    }
}
// @lc code=end

