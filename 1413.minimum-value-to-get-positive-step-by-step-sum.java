/*
 * @lc app=leetcode id=1413 lang=java
 *
 * [1413] Minimum Value to Get Positive Step by Step Sum
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int v:nums){
            sum+=v;
            min=Math.min(sum,min);
        }
        return min>0?1:-min+1;
    }
}
// @lc code=end

