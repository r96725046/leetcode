/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum=new int[10001];

        for(int i=0;i<nums.length;i++)
            sum[nums[i]]+=nums[i];
        for(int i=2;i<sum.length;i++)
            sum[i]=Math.max(sum[i]+sum[i-2],sum[i-1]);
        return sum[10000];
    }
}
// @lc code=end

