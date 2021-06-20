/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    // ****
    // 1.nums[i]<0 "swap" max ,min
    // 2.max/min*nums[i],nums[i]
    // 3.global max,max
    // 1
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return -1;
        int max=nums[0];
        int min=nums[0];
        int res=max;
        for(int i=1;i<nums.length;i++){

            if(nums[i]<0){
                int tmp=max;
                max=min;
                min=tmp;
            }
            max=Math.max(max*nums[i],nums[i]);
            min=Math.min(min*nums[i],nums[i]);
            res=Math.max(res,max);
        }
        return res;
    }
}
// @lc code=end

