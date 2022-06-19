/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    // ***
    public boolean canJump(int[] nums) {
        int reachable=0;
        for(int i=0;i<nums.length;i++){
            reachable=Math.max(reachable,i+nums[i]);
            if(reachable<i)
                return false;
        }
        return true;
    }
}
// @lc code=end

