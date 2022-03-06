/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(index==0||nums[i]!=nums[i-1])
                nums[index++]=nums[i];
        }
        return index;
    }
}
// @lc code=end

