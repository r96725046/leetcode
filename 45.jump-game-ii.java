/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    // ***
    public int jump(int[] nums) {
        if(nums.length<=1)
            return 0;
        int end=0;
        int max=0;
        int res=0;
        for(int i=0;i<nums.length-1;i++){           
            max=Math.max(max,i+nums[i]);
            if(i==end)
            {
                res++;
                end=max;
            }
        }

        return res;
    }
}
// @lc code=end

