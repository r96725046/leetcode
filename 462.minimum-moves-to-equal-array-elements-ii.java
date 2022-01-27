/*
 * @lc app=leetcode id=462 lang=java
 *
 * [462] Minimum Moves to Equal Array Elements II
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int m=nums.length/2;
        int res=0;
        for(int i=0;i<nums.length;i++){
            res+=Math.abs(nums[m]-nums[i]);
        }
        return res;
    }
}
// @lc code=end

