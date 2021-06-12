/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int[] count=new int[nums.length];
        int max=0;
        for(int i=nums.length-1;i>=0;i--){

            dp[i]=1;
            count[i]=1;
            for(int j=nums.length-1;j>=i;j--){
                if(nums[i]<nums[j]){  
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    //Count
                        count[i]=count[j];
                    }else  if(dp[j]+1==dp[i]){ 
                        count[i]+=count[j];
                    }
                }
            }
            max=Math.max(max,dp[i]);

        }
           
        int res=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]==max){
                res+=count[i];
            }
        }
            
        return res;
    }
}
// @lc code=end

