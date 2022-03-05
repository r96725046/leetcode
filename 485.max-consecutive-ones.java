/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0)return 0;
        int max=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
                c++;
            else
                c=0;
            max=Math.max(c,max);
        }
        return max;
    }
}
// @lc code=end

