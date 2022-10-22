/*
 * @lc app=leetcode id=1984 lang=java
 *
 * [1984] Minimum Difference Between Highest and Lowest of K Scores
 */

// @lc code=start
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE;
        for(int i=k-1;i<nums.length;i++){
            res=Math.min(res,nums[i]-nums[i-k+1]);
        }
        return res;
    }
}
// @lc code=end

