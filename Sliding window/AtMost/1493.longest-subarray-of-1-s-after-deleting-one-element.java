/*
 * @lc app=leetcode id=1493 lang=java
 *
 * [1493] Longest Subarray of 1's After Deleting One Element
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int start=0;
        int zeros=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeros++;
            while(zeros>1){
                if(nums[start]==0)
                    zeros--;
                start++;
            }
            max=Math.max(max,i-start);
            
        }
        return max;
    }
}
// @lc code=end

