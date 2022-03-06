/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        for(int v:nums)
            if(v!=0)nums[index++]=v;
        while(index<nums.length)
            nums[index++]=0;
    }
}
// @lc code=end

