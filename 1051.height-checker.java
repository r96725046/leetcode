/*
 * @lc app=leetcode id=1051 lang=java
 *
 * [1051] Height Checker
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        int[] nums=new int[heights.length];
        for(int i=0;i<nums.length;i++)
            nums[i]=heights[i];
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]!=heights[i])count++;
        return count;
    }
}
// @lc code=end

