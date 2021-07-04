/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    // ***
    // pre1=i-2
    // pre2=i-1
    // new pre2 will be max(nums[i]+pre1,pre2)
    public int rob(int[] nums) {
        int pre1=0;
        int pre2=0;
        for(int i=0;i<nums.length;i++){
            int tmp=pre2;
            pre2=Math.max(nums[i]+pre1,pre2);
            pre1=tmp;
        }
        return pre2;
    }
}
// @lc code=end

