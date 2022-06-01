/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros=0;

        int i=0;
        int j=0;
        int res=0;
        while(j<nums.length){
            if(nums[j]==0)
                zeros++;
            if(zeros<=k)
                res=Math.max(res,j-i+1);
            while(zeros>k&&i<=j){
                if(nums[i]==0)
                    zeros--;
                i++;
            }
            j++;
        }
        return res;
    }
}
// @lc code=end

