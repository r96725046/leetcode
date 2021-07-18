/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    // ***
    // 1.min,2nd min
    // 2.if value<min => min=value
    // 3.else value>min && value<2nd min => 2nd min=value
    // 4.return true
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

