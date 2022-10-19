/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    // 1.great or eq target
    // 2.can be a single element
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int min=Integer.MAX_VALUE;
        int cur=0;
        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            while(cur>=target){
                min=Math.min(min,i-start+1);
                cur-=nums[start];
                start++;
            }  
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
// @lc code=end

