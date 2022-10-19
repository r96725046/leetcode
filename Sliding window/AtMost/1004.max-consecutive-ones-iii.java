/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int max=Integer.MIN_VALUE;
        int zeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeros++;
            while(zeros>k){
                if(nums[start]==0)
                    zeros--;
                start++;
            }
            max=Math.max(i-start+1,max);
        }
        return max;
    }
}
// @lc code=end

