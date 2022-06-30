/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    //a ^ a = 0
    //a ^ 0 = a
    public int missingNumber(int[] nums) {
        int n=nums.length;

        int res=n;
        for(int i=0;i<nums.length;i++){
            res^=(i^nums[i]);
        }
        return res;
    }
}
// @lc code=end

