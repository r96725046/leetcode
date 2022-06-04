/*
 * @lc app=leetcode id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 */

// @lc code=start
class Solution {
    // The idea is always keep an max-product-window less than K;
    // Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
    // Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
    // example:
    // for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       int pro=1;
       int c=0;
       int j=0;
       int i=0;
       while(i<nums.length&&j<nums.length){
           pro*=nums[j];
           while(pro>=k&&i<=j){
               pro/=nums[i];
               i++;
           }
           c+=j-i+1;
           j++;
       } 
       return c;
    }
}
// @lc code=end

