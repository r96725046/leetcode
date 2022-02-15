/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int[] dp=new int[nums.length];

        Arrays.sort(nums);
        int[] pre=new int[dp.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            pre[i]=-1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        pre[i]=j;
                    }
                }
            }
        }
        int index=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max=dp[i];
                index=i;
            }
        }
        List<Integer> res=new ArrayList<>();
        while(index!=-1){
            res.add(0,nums[index]);
            index=pre[index];
        }
        return res;
    }
}
// @lc code=end

