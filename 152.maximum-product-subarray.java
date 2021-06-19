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
    public int maxProduct(int[] nums) {
        int max=1;
        int min=1;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int tmp=min;
                min=max;
                max=tmp;
            }
            max=Math.max(nums[i]*max,nums[i]);
            min=Math.min(nums[i]*min,nums[i]);

            res=Math.max(res,max);

        }
        return res;
    }
}
// @lc code=end

