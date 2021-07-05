/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=min)
                min=nums[i];
            else if(nums[i]>secondMin)
                return true;
            else
                secondMin=nums[i];
        }
        return false;
    }
}
// @lc code=end

