/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i>=k-1){
                res=Math.max(res,sum);
                sum-=nums[i-(k-1)];
            }
        }
        return res/1.0/k;
    }
}
// @lc code=end

