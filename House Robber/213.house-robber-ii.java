/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    // **
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    private int rob(int[] nums,int l,int r){
        int pre1=0;
        int pre2=0;
        for(int i=l;i<r;i++){
            int tmp=pre2;
            pre2=Math.max(nums[i]+pre1,pre2);
            pre1=tmp;
        }
        return pre2;
    }
}
// @lc code=end

